package vadooss1_homework.task_Hotel;

import java.util.HashMap;

public class Benchmark {
    public static void main(String[] args) {
        Resident r1 = new Resident("Gosha");
        Resident r2 = new Resident("Gena");
        Resident r3 = new Resident("Oleg");

        CustomResident c1 = new CustomResident("Gosha");
        CustomResident c2 = new CustomResident("Gena");
        CustomResident c3 = new CustomResident("Oleg");

        HashMap<Resident,Integer> map = new HashMap<>();
        HashMap<CustomResident,Integer> mapCustom = new HashMap<>();

        map.put(r1,1);
        map.put(r2,2);
        map.put(r3,3);
        mapCustom.put(c1,1);
        mapCustom.put(c2,2);
        mapCustom.put(c3,3);

        System.out.println("Cold");
        System.out.println("usual result - " + checkTimeGet(map,r2));
        System.out.println("collision result - " + checkTimeGet(mapCustom,c2));
        System.out.println("Warm");
        System.out.println("usual result - " + checkTimeGet(map,r2));
        System.out.println("collision result - " + checkTimeGet(mapCustom,c2));


    }
    static long checkTimeGet(HashMap map, Object key){
        long l = System.nanoTime();
        map.get(key);
        return System.nanoTime()-l;
    }

}
