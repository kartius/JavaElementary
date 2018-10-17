package ua.od.hillel.lesson_31_patterns.creational.builder;

public class BuilderExample {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
    }
}
