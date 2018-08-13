package lesson15HomeWork;

import java.util.ArrayList;
import java.util.Iterator;

public class Runner {
    public static void main(String[] args) {
        CustomArrayList customArrayList=new CustomArrayList();

        System.out.println("Check first size of list "+customArrayList.size());
        System.out.println("List is empty "+customArrayList.isEmpty());
        System.out.println("List contains Ann "+customArrayList.contains("Ann"));

        customArrayList.add(0,"Billy");
        customArrayList.add("Cindy");
        customArrayList.add("Dany");
        customArrayList.add("Mark");
        customArrayList.add("Ginger");
        customArrayList.add(5, "Richard");
        System.out.println(customArrayList.size());
        System.out.println(customArrayList.get(1));
        customArrayList.remove(1);
        System.out.println(customArrayList.get(1));
        System.out.println(customArrayList.indexOf("Dany"));
        customArrayList.add(2,"Roger");


        for (int i=0; i<customArrayList.size();i++){
            System.out.print(customArrayList.get(i)+" ");
        }
        System.out.println();

//        customArrayList.remove("Mark");


        for (int i=0; i<customArrayList.size();i++){
            System.out.print(customArrayList.get(i)+" ");
        }

        System.out.println();

//        customArrayList.clear();
        System.out.println(customArrayList.size());

        Iterator iterator=customArrayList.iterator();

        while (iterator.hasNext()){
            String s=iterator.next().toString();
            System.out.print(s+" ");
        }


        System.out.println();
        Iterator listIterator=customArrayList.listIterator();

        while (listIterator.hasNext()){
            String s=listIterator.next().toString();
            System.out.print(s+" ");
        }

    }

}
