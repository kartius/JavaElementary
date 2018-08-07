package lesson15;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.WeakHashMap;

public class Lesson15 {
    public static void main(String[] args) {



    Queue<Integer> queue=new LinkedList<>();

    queue.add(6);
    queue.add(8);
    queue.add(7);

    while (!queue.isEmpty()){
        System.out.println(queue.poll());
    }


    Queue<Integer> priorityQueue=new PriorityQueue<>();

    priorityQueue.add(5);
    priorityQueue.add(33);
    priorityQueue.add(4);

    while(!priorityQueue.isEmpty()) {
        System.out.println(priorityQueue.poll());
    }

        WeakHashMap<Object,String> weakHashMap=new WeakHashMap<>();
    Object obj=new Object();

    obj=null;

    System.gc();



}}
