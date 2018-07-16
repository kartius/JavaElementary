package JavaElementary.src.ua.od.hillel.anton_golyak;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the range: ");
        int range = in.nextInt();
        Double random_num = Math.random() * (double)range;
        System.out.println(random_num);
    }
}
