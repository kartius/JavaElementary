package vadooss1_homework.Collection;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add("aaa");
        customArrayList.add("bbb");
        customArrayList.add("ccc");
        customArrayList.add("ddd");

        long l = System.nanoTime();
        Iterator iterator = customArrayList.randomIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(System.nanoTime()-l);



    }
}
