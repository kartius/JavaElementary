package lesson14.hash;
import  java.util.*;
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,Double>hm=new HashMap<>();

        hm.put("John", new Double(34.34));
        hm.put("Mary", new Double(14.13));
        hm.put("Antony", 13.5); // Так тоже можно вводить
        hm.put(new String("Max"), 144.3);

        Set<Map.Entry<String,Double>> set=hm.entrySet();

        for (Map.Entry<String,Double> me:set
             ) {
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }
}
