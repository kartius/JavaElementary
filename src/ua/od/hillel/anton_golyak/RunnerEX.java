package JavaElementary.src.ua.od.hillel.anton_golyak;

import hillel.src.test.EX;

import java.util.Scanner;

public class RunnerEX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sum: ");
        double summ = in.nextDouble();

        System.out.println("Choose the option:");
        System.out.println("1: UAH->USD");
        System.out.println("2: USD->UAH");
        System.out.println("3: UAH->EUR");
        System.out.println("4: EUR->UAH");

        int var = in.nextInt();
        hillel.src.test.EX ex = new EX();
        ex.exchange(summ, var);
    }
}
