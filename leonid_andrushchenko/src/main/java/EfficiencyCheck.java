import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EfficiencyCheck {
    public static void main(String[] args) {
        System.out.println("cold");

        for(int i = 0; i < 2; i++)
        {
        System.out.println("Adding to the end");

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("\n When we have 5000 elements");
        int limit = 5000;
        System.out.println("ArrayList: " + add(arrayList, limit));
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("LinkedList: " + add(linkedList, limit));

        System.out.println("\n removing element");
        System.out.println("When we have 5000 elements");
        System.out.println("ArrayList: " + remove(arrayList, limit));
        System.out.println("LinkedList: " + remove(linkedList, limit));


        System.out.println("\n Adding to the end");
        System.out.println(" When we have 500000 elements");
        limit = 500000;
        System.out.println("ArrayList: " + add(arrayList, limit));
        System.out.println("LinkedList: " + add(linkedList, limit));


        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        System.out.println("\n Adding to the middle ");
        System.out.println(" When we have 5000 elements");
        limit = 5000;
        System.out.println("ArrayList: " + addToMiddle(arrayList, limit));
        System.out.println("LinkedList: " + addToMiddle(linkedList, limit));


        System.out.println("\n Getting element ");
        System.out.println(" When we have 5000 elements");
        System.out.println("ArrayList: " + get(arrayList, limit));
        System.out.println("LinkedList: " + get(linkedList, limit));



        if(i == 0){
            System.out.println("\n warm");}
        }
    }

    private static long add(List<Integer> list, int limit){
        long startTime = System.nanoTime();
        for(int i = 0; i < limit; i++){
            list.add(i);
        }

        return System.nanoTime() - startTime;
    }

    private static long addToMiddle(List<Integer> list, int limit){
        long startTime = System.nanoTime();
        for(int i = 0; i < limit; i++){
            list.add(list.size()/2, i);
        }

        return System.nanoTime() - startTime;
    }

    private static long remove(List<Integer> list, int limit){
        long startTime = System.nanoTime();

        for(int i = 0; i < limit; i++){
            list.remove(list.size()/2);
        }

        return System.nanoTime() - startTime;
    }

    private static long get(List<Integer> list, int limit){
        long startTime = System.nanoTime();
        int number;

        for(int i = 0; i < limit; i++){
            number = list.get(i);
        }

        return System.nanoTime() - startTime;
    }
}
