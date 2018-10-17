package ua.od.hillel.lesson_31_patterns.behavioral.strategy;

public class NormalStrategy implements BillingStrategy {
    @Override
    public double getFinishedPrice(double rawPrice) {
        return rawPrice;
    }
}
