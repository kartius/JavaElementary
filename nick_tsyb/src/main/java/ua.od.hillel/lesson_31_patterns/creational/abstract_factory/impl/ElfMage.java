package ua.od.hillel.lesson_31_patterns.creational.abstract_factory.impl;

import ua.od.hillel.lesson_31_patterns.creational.abstract_factory.Mage;

public class ElfMage implements Mage {
    @Override
    public void cast() {
        System.out.println("Elf cast");
    }
}
