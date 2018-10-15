package ua.od.hillel.lesson_31_patterns.creational.abstract_factory.impl;

import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Warrior;

public class ElfWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Elf attack");
    }
}
