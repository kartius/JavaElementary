package HashMapTask;

import java.util.HashMap;

public class Starter {
    public static void main(String[] args) {
        simpleBanchmark();
    }

    public static void simpleBanchmark(){
        System.out.print("HashCode is counted from the first letter of guest's surname: ");

        HashMap<Guest, String> hashMap = new HashMap<>();
        Guest guest1 = new Guest("aaaa");
        Guest guest2 = new Guest("abbb");
        hashMap.put(guest1, "room 1");
        hashMap.put(guest2, "room 2");

        long l = System.nanoTime();
        hashMap.get(guest1);
        hashMap.get(guest2);

        System.out.println(System.nanoTime() - l);

        System.out.print("HashCode is counted from whole guest's surname: ");
        HashMap<Guest, String> hashMap2 = new HashMap<>();
        guest1 = new ModifiedGuest("aaaa");
        guest2 = new ModifiedGuest("abbb");
        hashMap.put(guest1, "room 1");
        hashMap.put(guest2, "room 2");


        l = System.nanoTime();

        hashMap.get(guest1);
        hashMap.get(guest2);

        System.out.println(System.nanoTime() - l);
    }
}
