package JavaElementary.src.ua.od.hillel.anton_golyak;

import java.util.Scanner;

public class TaskFive {

    private static int f(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return f(index - 1) + f(index - 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of fib: ");
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(f(i) + " ");
        }
    }
}
