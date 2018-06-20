package ua.od.hillel.maksym_fedorovych.exchangeCurrency;

import java.util.Scanner;

public class RunExCur {
    public static void main(String[] args) {
     ExchangeCurr ExCur = new ExchangeCurr();
       int isocode;

        Scanner scaner = new Scanner(System.in);
        isocode = scaner.nextInt();


     ExCur.change(1,isocode, 978);

     //фівіві
    }
}
