package ua.od.hillel.lesson_13;

import java.util.*;

public class Runner {


    public static void simpleBanchmark() {
        List<Integer> list = new ArrayList<>();

        long l = System.nanoTime();

        for (int i = 0; i < 1500000; i++) {

            list.add(i);


        }


       System.out.println(System.nanoTime() - l);


    }


    public static void main(String[] args) {


        List<Integer> list = new ArrayList();

//        List<Integer> list1 = new LinkedList<>();
//
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println(list.size());
//        list.set(1, null);
//        System.out.println(list.size());
//        list.remove(1);
//        System.out.println(list.size());
//        System.out.println(list.get(2));


//        for (Integer integer : list) {
//            if (integer.equals(3))
////            list.set(1,3);
//            list.remove(integer);
//        }

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().equals(3))
//                iterator.remove();
//        }
//
//
//        long l = System.nanoTime();
//
//        list.add(1);
//
//
//        System.out.println(System.nanoTime() - l);


        System.out.println("cold");
        simpleBanchmark();
        System.out.println("warm");
        simpleBanchmark();


    }
}
