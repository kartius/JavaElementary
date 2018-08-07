package lesson14.hotel3;

import java.util.HashMap;
import java.util.Map;

public class Starter {
    public static void main(String[] args) {



    Resident resident1=new Resident("John");
    Resident resident2=new Resident("James");
    Resident resident3=new Resident("Jill");

    Resident resident4=new Resident("Antony");
    Resident resident5=new Resident("Bob");
    Resident resident6=new Resident("Carl");

    Room room1=new Room(1);
    Room room2=new Room(2);
    Room room3=new Room(3);



    Map<Resident,Room> hotel=new HashMap<>();
    Map<Resident,Room> hotel2=new HashMap<>();
    hotel.put(resident1,room1);
    hotel.put(resident2,room2);
    hotel.put(resident3,room3);
    hotel2.put(resident4,room1);
    hotel2.put(resident5,room2);
    hotel2.put(resident6,room3);

        System.out.println(resident1.hashCode()+" "+resident2.hashCode()+" "+
                resident3.hashCode());
        System.out.println(resident4.hashCode()+" "+resident5.hashCode()+" "+
                resident6.hashCode());

    long l=System.nanoTime();
    hotel.get(resident1);
    hotel.get(resident2);
    hotel.get(resident3);
        System.out.println(System.nanoTime()-l);

        l=System.nanoTime();
        hotel2.get(resident4);
        hotel2.get(resident5);
        hotel2.get(resident6);
        System.out.println(System.nanoTime()-l);




    }}
