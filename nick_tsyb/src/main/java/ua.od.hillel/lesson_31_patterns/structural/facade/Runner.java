package ua.od.hillel.lesson_31_patterns.structural.facade;

public class Runner {

    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }

}
