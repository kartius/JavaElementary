package ua.od.hillel.maksym_fedorovych;

import com.sun.javafx.css.CalculatedValue;

public class l3Factorial {
    /*
    Created by MaksF 17.06.2018
    Lesson3 Factorial
     */
    public static void main(String[] args) {
        int ValueFactorial = 5;
        int CalcValue = 1;
        for (int iCount = 2; iCount < ValueFactorial +1; iCount++)
        {
            CalcValue = CalcValue*iCount;

        }
        System.out.println(ValueFactorial + "! = " + CalcValue);
    }
}
