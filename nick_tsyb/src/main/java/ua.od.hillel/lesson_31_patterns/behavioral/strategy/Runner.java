package ua.od.hillel.lesson_31_patterns.behavioral.strategy;

public class Runner {


    public static void main(String[] args) {
        Customer customer = new Customer(new NormalStrategy());
        customer.printBill();
    }
}
