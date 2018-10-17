package ua.od.hillel.lesson_31_patterns.structural.flyweight;

public class Runner {

    public static void main (String [] args){
        FlyweightFactory factory = new FlyweightFactory();

        int [] characterCodes = {1,2,3};
        for (int nextCode : characterCodes){
            EnglishCharacter character = factory.getCharacter(nextCode);
            character.printCharacter();
        }
    }

}
