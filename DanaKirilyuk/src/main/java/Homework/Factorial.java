package Homework;

import java.util.Scanner;

public class Factorial {
    public static void main (String[] args){
        int number;
        int factorial = 1;

        System.out.println("Enter number to calculate factorial: ");
        Scanner F = new Scanner(System.in);
        number = F.nextInt();

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        System.out.println(number + "! = " + factorial);
    }
}