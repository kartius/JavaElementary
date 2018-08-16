package lesson15;

import java.util.ArrayList;
import java.util.Iterator;

public class Runner {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();

        for (int i = 1; i <= 10; i++){
            customArrayList.add(i + "");
        }

        customArrayList.add("w");
        customArrayList.add(5, "w");
        customArrayList.add(0, "w");

        Iterator backwardIterator = customArrayList.backwardIterator();

        while (backwardIterator.hasNext()){
            System.out.println(backwardIterator.next());
        }

        System.out.println("\n ----------- \n");

        Iterator randomIterator = customArrayList.randomIterator();

        while (randomIterator.hasNext()){
            System.out.println(randomIterator.next());
        }

        System.out.println("\n ----------- \n");


        customArrayList.remove("w");
        customArrayList.remove("w");
        customArrayList.remove("w");

        backwardIterator = customArrayList.backwardIterator();

        while (backwardIterator.hasNext()){
            System.out.println(backwardIterator.next());
        }
    }
}
