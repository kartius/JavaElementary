package ua.od.hillel.maksym_fedorovych.application;

public class Runner {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("ttt");

        calculator.sum(1234, 65656);

        calculator.div(1,0);

        calculator.calculate(1,2,'+' );
    }
}
