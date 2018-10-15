package ua.od.hillel.lesson_31_patterns.creational.abstract_factory;

public class FactoryCreator {

    public void create(SquadronFactory squadronFactory) {

        Mage mage = squadronFactory.createMage();
        Archer archer = squadronFactory.createArcher();
        Warrior warrior = squadronFactory.createWarrior();

    }
}
