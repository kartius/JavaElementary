package ua.od.hillel.danakirilyuk;

import java.util.Scanner;

public class Random {
    public static void main (String[] args) {
        int min, max;
        System.out.println("Enter min range of a random:");
        Scanner low = new Scanner(System.in);
        min = low.nextInt();

        System.out.println("Enter max range of a random:");
        Scanner high = new Scanner(System.in);
        max = high.nextInt();

        int random = (int) (Math.random() * (max - min) + min);

        System.out.println(random);
    }
}
