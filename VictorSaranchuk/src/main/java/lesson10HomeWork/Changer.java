package lesson10HomeWork;
import java.util.Scanner;

public class Changer {
    public static void main(String[] args) {

        //Replace @ and . - [at] and [dot]
        System.out.println("Enter E-Mail");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str1=str.replace("@","[at]").replace(".","[dot]");
        System.out.println(str1);


        //Check for palindromes
        System.out.println("Enter word for checking");
        String strNorm=sc.nextLine().trim();
        StringBuilder stringBuilder=new StringBuilder(strNorm).reverse();
        String palindrome=stringBuilder.toString();
        if (strNorm.equalsIgnoreCase(palindrome)==true){
            System.out.println("This is palindrome");
        }else{
            System.out.println("This is not palindrome\n");
        }

        //Check for quantity of palindromes
        System.out.println("Enter some word for checking palindromes");
        String strNorm2=sc.nextLine().trim();
        String words[]=strNorm2.split(" ");
        int count=0;
        for (String n:words
             ) {

            StringBuilder word= new StringBuilder(n);
            String palindrome2=word.reverse().toString();

            if (n.equalsIgnoreCase(palindrome2)==true) count++;
            }
        System.out.println("Quantity of palindromes is "+count);



        // first letter, number of letters between, last letter
        System.out.println("Enter some words");
        String strCheck=sc.nextLine().trim();
        StringBuilder strc=new StringBuilder(strCheck);
        String mass[]=strCheck.split(" ");

        for (String n:mass
             ) {
            if (n.length()<4){
            System.out.print(n+" ");}

            else{
                int c=((n.length()-2));
                char first=n.charAt(0);
                char last=n.charAt((n.length()-1));

                System.out.print(first+""+c+""+last+" ");

            }

        }

    }
}
