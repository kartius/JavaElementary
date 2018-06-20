package ua.od.hillel.maksym_fedorovych.exchangeCurrency;

public class ExchangeCurr {

    private double[] arrrate = new double[3]; //Курсы
    private int[] arriso = new int[3]; //iso коды валюты

    { //Инициализация
        //перевод меду не гривной происходит через гивну в два действия (для простоті віполняются два действия)
        arrrate[0] = 1.0000; //Курс относительно гривни
        arrrate[1] = 27.0000;
        arrrate[2] = 30.0000;

        arriso[0] = 980; /*UAH*/
        arriso[1] = 840; /*USD*/
        arriso[2] = 978; /*EUR*/


        System.out.println("HelloTestApp");
    }
    public void change (double Amount, int isocode, int isocodeNew){
        boolean bNotFound = true;
        for (int i = 0; i < arriso.length; i++) {
          if (arriso[i] == isocode)
          { //нашли курс перевода в гривну
             for (int j = 0; j < arriso.length; j++)
             {
               if (arriso[j] == isocodeNew)
               { //нашли курс перевода в другую валюту
                   System.out.println(Amount +" " + arriso[i] + " = "  +  Amount*arrrate[i]/arrrate[j] + " " +  arriso[j]);
                   bNotFound = false;
               }
             }

          }
        }
        if (bNotFound)
        {
          System.out.println("Одна из валют указана не правильно");
        }
    }


}
