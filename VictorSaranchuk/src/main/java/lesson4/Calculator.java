package lesson4;

public class Calculator {
    public Calculator(String str){
        System.out.println("Hello "+str);
    }

    public void calculate(double first,double second, char operator) {
        for (char c : operators) {
            if (c == operator) {
                internalCalculate(first, second, operator);
            } else {
                System.out.println("incorrect" + operator);
                break;
            }


        }
    }
    private char[] operators={'+','-','/','*'};

    private void internalCalculate(double first,double second, char operator){
        switch(operator){
            case '+':
                System.out.println(first+second);
                break;
            case '-':
                System.out.println(first-second);
                break;
            case '/':
                System.out.println(first/second);
                break;
            case '*':
                System.out.println(first*second);
                break;


        }
    }

    public void sum(double first,double second){
        System.out.println(first+second);
    }
    public void subt(double first,double second){
        System.out.println(first-second);
    }
    public void div(double first,double second){
        System.out.println(first/second);
    }
    public void mult(double first,double second){
        System.out.println(first*second);
    }
}

