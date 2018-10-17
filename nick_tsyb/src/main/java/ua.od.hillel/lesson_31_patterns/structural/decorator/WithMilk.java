package ua.od.hillel.lesson_31_patterns.structural.decorator;

public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }
}
