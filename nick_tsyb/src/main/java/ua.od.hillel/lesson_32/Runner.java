package ua.od.hillel.lesson_32;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {


    public List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }


    public List<Apple> filterApples(List<Apple> inventory, String color, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((apple.getWeight() > weight) && (apple.getColor().equals(color))) {
                result.add(apple);
            }
        }
        return result;
    }


    public List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.filterApples(new ArrayList<Apple>(), new AppleGreenColorPredicate());



        runner.filterApples(new ArrayList<Apple>(), apple -> "green".equals(apple.getColor()));


        List<Apple> list = new ArrayList<>();


        List<Apple> green = list.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());


    }


}
