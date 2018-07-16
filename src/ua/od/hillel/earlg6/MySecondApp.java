package ua.od.hillel.earlg6;

import java.util.Scanner;

public class MySecondApp {

    public static void main(String[] args) {

        MySecondApp random = new MySecondApp();

        //moon weight

        System.out.println("On Earth?\nEnter your weight");

        Scanner sc = new Scanner(System.in);

        double weight = sc.nextDouble();

        System.out.println("Ok, on Moon u will be " + 0.17 * weight + " kg\n");

        //replace

        System.out.println("Replace");

        String str1 = "1lesson1lesson1lesson";

        String str2 = str1.replace("1", "2");

        System.out.println("Substitution of 1 to 2: " + str2);


        StringBuffer str3 = new StringBuffer(str2);


        for (int i = 0; i < str2.length(); i++) {

            i = str3.indexOf("n", i);

            str3.insert(i + 1, " ");

        }

        System.out.print("Space created: ");

        System.out.println(str3 + "\n");


        
        System.out.println("Rand\n" + random.randomNumber(1, 10));
        
    }

    // random

    public int randomNumber(int a, int b) {


        int x = (int) (a + Math.random() * b);

        return x;

    }

}

