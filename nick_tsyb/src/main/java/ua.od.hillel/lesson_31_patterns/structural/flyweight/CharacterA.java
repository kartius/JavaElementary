package ua.od.hillel.lesson_31_patterns.structural.flyweight;

public class CharacterA extends EnglishCharacter {

    public CharacterA(){
        symbol = 'A';
        width = 10;
        height = 20;
    }

    @Override
    public void printCharacter() {
        System.out.println("Simbol = " + symbol + " Width = " + width + " Height = " + height);
    }

}
