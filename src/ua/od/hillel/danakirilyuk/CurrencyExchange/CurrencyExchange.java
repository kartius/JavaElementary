package ua.od.hillel.danakirilyuk.CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {

    public static void main (String[] str) {
        System.out.println("Currency exchange");

        int amount;
        String currency;

        System.out.println("Enter amount in UAH: ");
        Scanner A = new Scanner(System.in);
        amount = A.nextInt();

        System.out.println("Enter output currency: USD, EUR, RUB, GBP.");
        Scanner C = new Scanner(System.in);
        currency = C.next();

        switch (currency) {
            case "USD":
                System.out.println(amount * 26.406);
                break;
            case "EUR":
                System.out.println(amount * 30.7033);
                break;
            case "RUB":
                System.out.println(amount * 0.4162);
                break;
            case "GBP":
                System.out.println(amount * 35.256);
                break;
            default:
                System.out.println("You have entered incorrect currency. Please choose the one from the list and try again.");
        }

    }

}
