package ua.od.hillel.lesson_31_patterns.behavioral.strategy;

public class Customer {

    private BillingStrategy strategy;

    public Customer(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public void printBill(){
        double sum = 0;
        double finishedPrice = strategy.getFinishedPrice(sum);
        System.out.println(finishedPrice);
    }
}
