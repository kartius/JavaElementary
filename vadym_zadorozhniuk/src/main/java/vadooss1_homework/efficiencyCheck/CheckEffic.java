package vadooss1_homework.efficiencyCheck;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckEffic {
    public static void main(String[] args) {
        int capacity = 5;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < capacity; i++) {
            linkedList.add(i);
        }
        System.out.println("cold");
        arrayListAddLast(arrayList);
        System.out.println("warm");
        arrayListAddLast(arrayList);
        System.out.println(arrayList.indexOf(0));


    }
static void arrayListAddMiddle(ArrayList arrayList){
        long l = System.nanoTime();
        arrayList.add(arrayList.size()/2, 1);
    System.out.println(System.nanoTime()-l);
}
static void arrayListAddLast(ArrayList arrayList){
    long l = System.nanoTime();
    arrayList.add(1);
    System.out.println(System.nanoTime()-l);
}
static void arrayListDel(ArrayList arrayList){
    long l = System.nanoTime();
    arrayList.remove(1);
    System.out.println(System.nanoTime()-l);
}
static void arrayListGet(ArrayList arrayList){
    long l = System.nanoTime();
    arrayList.get(1);
    System.out.println(System.nanoTime()-l);
}
    static void linkedListAddMiddle(LinkedList linkedList){
        long l = System.nanoTime();
        linkedList.add(linkedList.size()/2, 1);
        System.out.println(System.nanoTime()-l);
    }
    static void linkedListAddLast(LinkedList linkedList){
        long l = System.nanoTime();
        linkedList.add(1);
        System.out.println(System.nanoTime()-l);
    }
    static void linkedListDel(LinkedList linkedList){
        long l = System.nanoTime();
        linkedList.remove(1);
        System.out.println(System.nanoTime()-l);
    }
    static void linkedListGet(LinkedList linkedList){
        long l = System.nanoTime();
        linkedList.get(1);
        System.out.println(System.nanoTime()-l);
    }

}
