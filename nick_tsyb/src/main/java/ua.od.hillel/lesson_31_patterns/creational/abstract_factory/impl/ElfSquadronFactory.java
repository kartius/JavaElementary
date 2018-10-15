package ua.od.hillel.lesson_31_patterns.creational.abstract_factory.impl;

import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Archer;
import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Mage;
import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.SquadronFactory;
import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Warrior;

public class ElfSquadronFactory extends SquadronFactory {

    @Override
    public Mage createMage() {
        return new ElfMage();
    }

    @Override
    public Archer createArcher() {
        return new ElfArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new ElfWarrior();
    }
}
