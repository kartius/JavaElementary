package ua.od.hillel.lesson_31_patterns.creational.abstract_factory.impl;

import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Archer;

public class ElfArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Elf shoot");
    }
}
