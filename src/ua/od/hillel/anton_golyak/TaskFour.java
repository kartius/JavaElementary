package JavaElementary.src.ua.od.hillel.anton_golyak;

import java.util.Scanner;

public class TaskFour {
    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter num: ");
        int factorial = in.nextInt();
        System.out.println(calculateFactorial(factorial));
    }
}
