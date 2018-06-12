package ua.od.hillel.blackbackroom;
import java.util.Scanner;
public class MySecondApplication {
    public static void main(String[] args) {
        System.out.println("Chapter 1\nВведите массу вашего тела");
        Scanner sc=new Scanner(System.in);
        double m=sc.nextDouble();
        System.out.println("Ваша масса на Луне составит\n"+0.17*m);

        String s="1lesson1lesson1lesson";
        System.out.println("\n\nChapter 2\nДана строка ");
        System.out.println("Замена 1 на 2");
        String s1=s.replace("1","2");
        System.out.println("Результат: "+s1);

        StringBuffer s2= new StringBuffer(s1);
        for(int i=0;i<s1.length();i++){
            i=s2.indexOf("n",i);
            s2.insert(i+1," ");

        }
        System.out.println(s2);
        
    }

}
