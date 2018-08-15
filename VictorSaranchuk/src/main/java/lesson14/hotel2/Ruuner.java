package lesson14.hotel2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Ruuner {
    public static void main(String[] args) {
//        Map<Client, String> clientStringMap=new HashMap<>();
//        Client client1=new Client("111");
//        Client client2=new Client("112");
//
//        clientStringMap.put(client1, "1");
//        clientStringMap.put(client2,"2");
//
//        System.out.println(client1.hashCode());
//        System.out.println(client2.hashCode());


        HashMap<Integer, String> map=new HashMap<>();

        map.put(5,"5");
        map.put(4,"4");
        map.put(3,"3");
        System.out.println(map);

        LinkedHashMap<Integer, String> map1=new LinkedHashMap<>(map);
        System.out.println(map1);
    }
}
