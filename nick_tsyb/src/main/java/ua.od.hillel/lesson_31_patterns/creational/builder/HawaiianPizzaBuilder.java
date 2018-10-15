package ua.od.hillel.lesson_31_patterns.creational.builder;

public class HawaiianPizzaBuilder extends PizzaBuilder {

    public void buildDough()   { pizza.setDough("cross"); }
    public void buildSauce()   { pizza.setSauce("mild"); }
    public void buildTopping() { pizza.setTopping("ham+pineapple"); }
}
