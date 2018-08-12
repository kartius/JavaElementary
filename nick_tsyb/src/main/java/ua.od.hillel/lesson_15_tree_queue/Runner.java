package ua.od.hillel.lesson_15_tree_queue;

import java.util.*;

public class Runner {


    public static void main(String[] args) {


//        Map<Client, String> clientsMap = new HashMap<>();
//
//
//        Client client1 = new Client("aaaa");
//        Client client2 = new Client("abbb");
//
//
//        clientsMap.put(client1, "1");
//        clientsMap.put(client2, "11");
//
//
//        clientsMap.get(client1);
//
//
//        System.out.println(client1.hashCode());
//        System.out.println(client2.hashCode());


        HashMap<Integer, String> map = new HashMap<>();


        map.put(5, "a");
        map.put(3, "b");
        map.put(1, "c");


//        System.out.println(map);


        LinkedHashMap<Integer, String> linkedHashmap = new LinkedHashMap<>();
        linkedHashmap.put(5, "a");
        linkedHashmap.put(3, "b");
        linkedHashmap.put(1, "c");


//        System.out.println(linkedHashmap);


//        EnumMap


        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();


        Object obj = new Object();

        weakHashMap.put(obj, "sddsf");


        obj = null;

//        System.gc();


        for (int i = 0; i <500000 ; i++) {

            if (weakHashMap.isEmpty()){
                System.out.println("empty");
               break;
            }else{
                System.out.println(i+" _sdfsdf");
            }
        }

        Queue<Integer> queue = new LinkedList<>();


        queue.add(6);
        queue.add(2);
        queue.add(33);
        queue.add(1);


        while (!queue.isEmpty())
            System.out.println(queue.poll());


    }


}
