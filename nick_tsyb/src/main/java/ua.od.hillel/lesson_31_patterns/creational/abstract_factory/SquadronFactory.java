package ua.od.hillel.lesson_31_patterns.creational.abstract_factory;

public abstract class SquadronFactory {

    public abstract Mage createMage();

    public abstract Archer createArcher();

    public abstract Warrior createWarrior();
}
