package HashCode;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void guestHashCode() {

        Map<Guest, String> guestMap = new HashMap<Guest, String>();

        Guest guest1 = new Guest("Petrov");
        Guest guest2 = new Guest("Ptuhin");
        Guest guest3 = new Guest("Perevalov");
        Guest guest4 = new Guest("Petrenko");
        Guest guest5 = new Guest("Pushkin");
        Guest guest6 = new Guest("Pavin");
        Guest guest7 = new Guest("Pokuro");
        Guest guest8 = new Guest("Pasternak");
        Guest guest9 = new Guest("Pilko");
        Guest guest10 = new Guest("Plavin");
        Guest guest11 = new Guest("Privalov");
        Guest guest12 = new Guest("Pykin");

        guestMap.put(guest1, "21");
        guestMap.put(guest2, "45");
        guestMap.put(guest3, "1");
        guestMap.put(guest4, "8");
        guestMap.put(guest5, "56");
        guestMap.put(guest6, "7");
        guestMap.put(guest7, "31");
        guestMap.put(guest8, "6");
        guestMap.put(guest9, "4");
        guestMap.put(guest10, "10");
        guestMap.put(guest11, "12");
        guestMap.put(guest12, "20");

        guestMap.get(guest1);

        System.out.println("Hash code for the first letter:");

        System.out.println(guest1.hashCode());
        System.out.println(guest2.hashCode());
        System.out.println(guest3.hashCode());
        System.out.println(guest4.hashCode());
        System.out.println(guest5.hashCode());
        System.out.println(guest6.hashCode());
        System.out.println(guest7.hashCode());
        System.out.println(guest8.hashCode());
        System.out.println(guest9.hashCode());
        System.out.println(guest10.hashCode());
        System.out.println(guest11.hashCode());
        System.out.println(guest12.hashCode());
    }

    public static void guestFullHashCode() {

        Map<GuestFull, String> guestMapFull = new HashMap<GuestFull, String>();

        GuestFull guestFull1 = new GuestFull("Petrov");
        GuestFull guestFull2 = new GuestFull("Ptuhin");
        GuestFull guestFull3 = new GuestFull("Perevalov");
        GuestFull guestFull4 = new GuestFull("Petrenko");
        GuestFull guestFull5 = new GuestFull("Pushkin");
        GuestFull guestFull6 = new GuestFull("Pavin");
        GuestFull guestFull7 = new GuestFull("Pokuro");
        GuestFull guestFull8 = new GuestFull("Pasternak");
        GuestFull guestFull9 = new GuestFull("Pilko");
        GuestFull guestFull10 = new GuestFull("Plavin");
        GuestFull guestFull11 = new GuestFull("Privalov");
        GuestFull guestFull12 = new GuestFull("Pykin");

        guestMapFull.put(guestFull1, "24");
        guestMapFull.put(guestFull2, "04");
        guestMapFull.put(guestFull3, "64");
        guestMapFull.put(guestFull4, "80");
        guestMapFull.put(guestFull5, "15");
        guestMapFull.put(guestFull6, "31");
        guestMapFull.put(guestFull7, "06");
        guestMapFull.put(guestFull8, "09");
        guestMapFull.put(guestFull9, "11");
        guestMapFull.put(guestFull10, "20");
        guestMapFull.put(guestFull11, "31");
        guestMapFull.put(guestFull12, "01");

        System.out.println("Hash code for the full surname");

        System.out.println(guestFull1.hashCode());
        System.out.println(guestFull2.hashCode());
        System.out.println(guestFull3.hashCode());
        System.out.println(guestFull4.hashCode());
        System.out.println(guestFull5.hashCode());
        System.out.println(guestFull6.hashCode());
        System.out.println(guestFull7.hashCode());
        System.out.println(guestFull8.hashCode());
        System.out.println(guestFull9.hashCode());
        System.out.println(guestFull10.hashCode());
        System.out.println(guestFull11.hashCode());
        System.out.println(guestFull12.hashCode());

    }

    public static void simpleBanchmark() {
        long startTime1 = System.nanoTime();
        guestHashCode();
        long endTime1 = System.nanoTime();
        System.out.println("Totat execution time (first letter):" + (endTime1 - startTime1));

        long startTime2 = System.nanoTime();
        guestFullHashCode();
        long endTime2 = System.nanoTime();
        System.out.println("Totat execution time (full surname):" + (endTime2 - startTime2));
    }

    public static void main(String[] args) {
        System.out.println();
        simpleBanchmark();

    }

}