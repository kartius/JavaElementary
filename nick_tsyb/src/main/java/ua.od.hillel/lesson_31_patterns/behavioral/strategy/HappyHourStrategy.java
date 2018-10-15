package ua.od.hillel.lesson_31_patterns.behavioral.strategy;

public class HappyHourStrategy implements BillingStrategy {
    @Override
    public double getFinishedPrice(double rawPrice) {
        return rawPrice * 0.5;
    }
}
