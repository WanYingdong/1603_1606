package test2;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
class Student{
    String name,sex,number;
    int age;
    double grade;
    Student(){
        this.number="";
        this.name="";
        this.sex="";
        this.age=0;
        this.grade=0;
    }
    Student(String a,String b,int c,double d,String number){
        this.number=number;
        this.name=a;
        this.sex=b;
        this.age=c;
        this.grade=d;
    }
    public void setnumber(String a){
        this.number=a;
    }
    public void setsex(String a){
        this.sex=a;
    }
    public void setname(String a){
        this.name=a;
    }
    public void setage(int a){
        this.age=a;
    }
    public void setgrade(double a){
        this.grade=a;
    }
    public void getnumber(){
        System.out.println(this.number);
    }
    public void getname(){
        System.out.println(this.name);
    }
    public void getsex(){
        System.out.println(this.sex);
    }
    public void getage(){
        System.out.println(this.age);
    }
    public void getgrade(){
        System.out.println(this.grade);
    }
    public String toString()
    {
       return getClass().getName()
          + "ѧ��"+number+" "+"����"+name+" "+"����"+String.valueOf(age)+" "+"�Ա� �� "+" "+"�ɼ�"+String.valueOf(grade);
    }
}

public class OpStudent {
    public static void main(String[] args)throws IOException{
        FileWriter fw = null;
        int count=5;
        Student[] s=new Student[10];
        s[0]=new Student("a","��",18,50,"1");
        s[1]=new Student("b","��",18,50,"2");
        s[2]=new Student("c","��",18,50,"3");
        s[3]=new Student("d","��",18,50,"4");
        s[4]=new Student("e","��",18,50,"5");
        String savepath="C:\\experiment.txt";
        Write(savepath,s);
        Login(s,count);
}
    public static void Write(String savepath,Student[] s){
        //��̬�����洢����ֱ�ӵ��á�
        try{
            PrintWriter ps = new PrintWriter(new FileWriter(savepath),true);
            ps.println(s.length);
            ps.println("ѧ��\t����\t����\t�Ա�\t�ɼ�");
            for(int i=0;i<s.length-1;i++){
                ps.println(s[i].number+"|"+s[i].name+"|"+String.valueOf(s[i].age)+"|"+s[i].sex+"|"+String.valueOf(s[i].grade));
            }
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void Read(int i){
        try{
            String s="";
            //��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ������throw
            /*����txt�ļ�*/
            String pathname="C:\\experiment.txt";//����·��
            File filename=new File(pathname);//��ȡ·���ϵ��ļ�
            InputStreamReader reader=new InputStreamReader(
                    new FileInputStream(filename));//����һ������������
            BufferedReader br=new BufferedReader(reader);//����һ�����󣬰��ļ�����ת��Ϊ2���ƣ�����
            String line=br.readLine();
            for(int j=0;j!=i;j++)
                line=br.readLine();
            s=s+line;
            System.out.println(s);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void Login(Student[] a,int count)throws IOException{
        
        String s1="*****************************************\n";
        s1=s1+"  ʯ��ׯ������ѧ�������ϵѧ����Ϣ����ϵͳ    \n";
        s1=s1+"*****************************************\n";
        s1=s1+"    1���������ѧ����Ϣ\n";
        s1=s1+"    2����ѧ����Ϣ¼��\n";
        s1=s1+"    3��ɾ��ѧ����Ϣ\n";
        s1=s1+"    4���޸�ѧ����Ϣ\n";
        s1=s1+"    5����ѯѧ����Ϣ\n";
        s1=s1+"    6��ͳ��ѧ������������\n";
        s1=s1+"    7������7��������";
        do{
        System.out.println(s1);
        Scanner s2=new Scanner(System.in);
        int i=s2.nextInt();
        if(i==1)
            {
            System.out.println("ѧ��\t����\t����\t�Ա�\t�ɼ�\r\n");
            for(int x=1;x<=4;x++)
                Read(x);}
        else if(i==2)
            {
            Scanner p=new Scanner(System.in);
            System.out.println("����ѧ��");
            a[count].number=p.nextLine();
            System.out.println("��������");
            a[count].name=p.nextLine();
            System.out.println("��������");
            a[count].age=p.nextInt();
            System.out.println("�����Ա�");
            a[count].sex=p.nextLine();
            System.out.println("�������");
            a[count].grade=p.nextDouble();
            count ++;
            Write("C:\\experiment.txt",a);   
            }
        else if(i==3){
            System.out.println("����ѧ��ѧ��");
            Scanner ss=new Scanner(System.in);
            String num=ss.next();
            BufferedReader in = new BufferedReader(new FileReader("C:\\experiment.txt"));
            String sm = in.readLine();
            String sm1 = in.readLine();
            Student[] temp=new Student[6];
            for(int m=0;m<=6;m++){
                String s = in.readLine();
                StringTokenizer t = new StringTokenizer(s, "|");
                String nu=t.nextToken();
                if(nu.equals(num))
                {temp[m].name=t.nextToken();
                temp[m].age=Integer.parseInt(t.nextToken());
                temp[m].sex =t.nextToken();
                temp[m].grade=Double.parseDouble(t.nextToken());}
                else
                    m=m-1;
                } 
            Write("C:\\experiment.txt",temp);
            
            in.close();
        }
        else if(i==4){
            
        }
        else if(i==5){
            BufferedReader in = new BufferedReader(new FileReader("C:\\experiment.txt"));
            int ap = Integer.parseInt(in.readLine());
            Student[] temp=new Student[1];
            String sm = in.readLine();    
            System.out.println(sm);
            for(int m=1;m<=5;m++){
                String s = in.readLine();
                StringTokenizer t = new StringTokenizer(s, "|");
                System.out.println("ѧ��"+t.nextToken()+" "+"����"+t.nextToken()+" "+"����"+t.nextToken()+" "+"�Ա� �� "+" "+"�ɼ�"+t.nextToken());
               }
            
            in.close();
        }
        else if(i==6){
            int nums=0;
            BufferedReader in = new BufferedReader(new FileReader("C:\\experiment.txt"));
            String sm = in.readLine();
            String sm1 = in.readLine();
            System.out.println(sm1);
            for(int m=1;m<=5;m++){
            String s = in.readLine();
            StringTokenizer t = new StringTokenizer(s, "|");
            String num=t.nextToken();
            String na11m=t.nextToken();
            String age=t.nextToken();
            String sex=t.nextToken();
            double grade=Double.parseDouble(t.nextToken());           
            if(grade<=60)
                nums++;
            } 
            System.out.println("�����������Ϊ"+nums);         
        }
        else
            break;
        }while(true);
    }
    }