package ua.od.hillel.danakirilyuk;

import java.util.Scanner;

public class WeightOnTheMoon {
    public static void main (String[] args) {
        float weight;
        System.out.println("To calculate your weight on the Moon please enter your weight:");
        Scanner W = new Scanner(System.in);
        weight = W.nextInt();

        float moonw;
        moonw = weight * 17 / 100;

        System.out.println("So on the Moon your weight will be " + moonw + " kilogram.");
    }
}
