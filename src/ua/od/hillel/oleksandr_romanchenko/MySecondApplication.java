package ua.od.hillel.oleksandr_romanchenko;

import java.util.Scanner;

public class MySecondApplication {

    public static void main(String[] args) {

        MySecondApplication random = new MySecondApplication();

        //task 1

        System.out.println("task 1\nEnter your weight");
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        System.out.println("Your weight on the moon will be " + 0.17 * weight + " kg\n");

        //task 2

        System.out.println("task 2");
        String str1 = "1lesson1lesson1lesson";
        String str2 = str1.replace("1", "2");
        System.out.println("Substitution of 1 to 2: " + str2);

        StringBuffer str3 = new StringBuffer(str2);

        for (int i = 0; i < str2.length(); i++) {
            i = str3.indexOf("n", i);
            str3.insert(i + 1, " ");
        }
        System.out.print("Adding spaces: ");
        System.out.println(str3 + "\n");

        System.out.println("task 3\n" + random.randomNumber(1, 10));
    }

    // task 3

    public int randomNumber(int a, int b) {     // a, b - boarders of a random number

        int x = (int) (a + Math.random() * b);
        return x;
    }
}
