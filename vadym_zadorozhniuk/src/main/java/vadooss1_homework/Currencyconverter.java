package vadooss1_homework;

import java.util.Scanner;

public class Currencyconverter {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);

        double courseUAH_USD = 27;
        double courseUAH_EUR = 32;
        double courseUSD_UAH = 26.5;
        double courseEUR_UAH = 31.5;
        double courseUSD_EUR = 1.17;
        double courseEUR_USD = 1.16;
        int userValue;
        int userCurrency;
        int convertTo;

        System.out.print("Enter integer value -> ");
        while(!ms.hasNextInt()){
            System.out.print("Invalid data! Input only integers! -> ");
            ms.next();
        }
        userValue = ms.nextInt();

        do{
            System.out.print("Enter index your currency: 1 for UAH, 2 for USD, 3 for EUR -> ");
            while(!ms.hasNextInt()) {
               System.out.print("Invalid data! Input only integers! 1 for UAH, 2 for USD, 3 for EUR -> ");
               ms.next();
           }
            userCurrency=ms.nextInt();
        }while(userCurrency<=0||userCurrency>3);

        do{
            System.out.print("Enter currency index in which to convert: 1 for UAH, 2 for USD, 3 for EUR -> ");
            while(!ms.hasNextInt()) {
                System.out.print("Invalid data! Input only integers! 1 for UAH, 2 for USD, 3 for EUR -> ");
                ms.next();
            }
            convertTo=ms.nextInt();
        }while(convertTo<=0||convertTo>3);

        if(userCurrency==1&&convertTo==1){System.out.println("It is "+userValue+" UAH");}
        if(userCurrency==2&&convertTo==2){System.out.println("It is "+userValue+" USD");}
        if(userCurrency==3&&convertTo==3){System.out.println("It is "+userValue+" EUR");}
        if(userCurrency==1&&convertTo==2){System.out.println("It is "+userValue*courseUAH_USD+" USD");}
        if(userCurrency==1&&convertTo==3){System.out.println("It is "+userValue*courseUAH_EUR+" EUR");}
        if(userCurrency==2&&convertTo==1){System.out.println("It is "+userValue*courseUSD_UAH+" UAH");}
        if(userCurrency==2&&convertTo==3){System.out.println("It is "+userValue/courseUSD_EUR+" EUR");}
        if(userCurrency==3&&convertTo==1){System.out.println("It is "+userValue*courseEUR_UAH+" UAH");}
        if(userCurrency==3&&convertTo==2){System.out.println("It is "+userValue*courseEUR_USD+" USD");}

    }

}
