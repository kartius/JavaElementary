package ua.od.hillel.maksym_fedorovych.exchangeCurrency;

import java.util.Scanner;

public class RunExCur {
    public static void main(String[] args) {
     ExchangeCurr ExCur = new ExchangeCurr();
       int isocode;
       int isocodeNew;
       double Amount;
       Scanner scaner = new Scanner(System.in);

       System.out.println("Введите первичную валюту: ");
       isocode = scaner.nextInt();
       System.out.println("Введите валюту в которую необходимо проконвертировать сумму: ");
       isocodeNew = scaner.nextInt();

        System.out.println("Введите сумму: ");
        Amount = scaner.nextDouble();
//test
     ExCur.change(Amount,isocode, isocodeNew);

     //фівіві
    }
}
