package lesson13;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class CompareArraiAndLinked {
    public static void main(String[] args) {


    List<Integer> arrayList=new ArrayList<Integer>(5000);
    List<Integer> linkedList=new LinkedList<Integer>();


long t=System.nanoTime();

for (int i=0; i<5000; i++){
    arrayList.add(i);
}
        System.out.println("ArrayList add at "+(System.nanoTime()-t));

t=System.nanoTime();

for (int i=0; i<5000; i++){
    linkedList.add(i);
}
        System.out.println("LinkedList add at "+(System.nanoTime()-t));

t=System.nanoTime();
for (int i=0; i<5000; i++){
    arrayList.add(2500, i);
}
        System.out.println("ArrayList add 2500 at "+(System.nanoTime()-t));

t=System.nanoTime();
for(int i = 0; i<5000; i++){
    linkedList.add(2500,i);
}
        System.out.println("LinkedList add 2500 at "+(System.nanoTime()-t));

t=System.nanoTime();
for (int i=0; i<5000; i++){
    arrayList.add((arrayList.size()-arrayList.size()%2)/2,i);
}
        System.out.println("ArrayList add to center at "+(System.nanoTime()-t));

t=System.nanoTime();
for (int i=0;i<5000;i++){
    linkedList.add((linkedList.size()-linkedList.size()%2)/2,i);
}
        System.out.println("LinkedList add to center at "+(System.nanoTime()-t));

    }}
