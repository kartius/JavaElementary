package ua.od.hillel.vadim_zadorozhnyuk.Collection;

import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add("aaa");
        System.out.println(customArrayList.get(0));
        customArrayList.remove("aaa");

        Iterator iterator = customArrayList.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());



    }
}
