package ua.od.hillel.danakirilyuk.lesson4.application;

public class Calculator {

    public Calculator(String str) {
        System.out.println("Hello " + str);
    }

    private char[] operators = {'+', '-', '/', '*'};

    public void calculate(double first, double second, char operator) {

        for (char c : operators) {
            if (c == operator) {
                internalCalculate(first, second, operator);
            } else {
                System.out.println("Incorrect operator " + operator);
                break;
            }
        }

        internalCalculate(first, second, operator);
    }


    private void internalCalculate(double first, double second, char operator) {
        switch (operator) {
            case '+':
                System.out.println(first + second);
                break;
            case '-':
                System.out.println(first - second);
                break;
            case '/':
                System.out.println(first / second);
                break;
            case '*':
                System.out.println(first * second);
                break;
        }

    }






    public void sum (double first, double second) {
        System.out.println(first + second);
    }

    public void subt (double first, double second) {
        System.out.println(first - second);
    }

    public void div (double first, double second) {
        System.out.println(first / second);
    }

    public void mult (double first, double second) {
        System.out.println(first * second);
    }
}
