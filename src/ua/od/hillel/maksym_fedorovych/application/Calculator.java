package ua.od.hillel.maksym_fedorovych.application;

public class Calculator {

    public Calculator(String str) {
       // System.out.println("Hello"+ str);
       }

       private char[] operators = {'+', '-', '/', '*'};

       public void calculate (double first, double second, char operator){

           for (char c: operators) {
               if (c == operator) {
                 System.out.println(c);
               }
           }
       internalcalculate(first,second,operator);


       }

       private void internalcalculate(double first, double second, char operator){
           switch (operator) {
               case '+':
                   System.out.println(first + second);
                   break;
               case '-':
                   System.out.println(first - second);
                   break;
               case '/':
                   System.out.println(first/second);
                   break;
               case '*':
                   System.out.println(first*second);
                   break;
               default:
                   System.out.println("Unknown operation");
           }


       }

       public void sum (double first, double second)
     {
         System.out.println(first + second);
     }

    public void subt (double first, double second)
    {
        System.out.println(first - second);
    }

    public void div (double first, double second)
    {
        System.out.println(first / second);
    }
    public void mult (double first, double second)
    {
        System.out.println(first * second);
    }
}
