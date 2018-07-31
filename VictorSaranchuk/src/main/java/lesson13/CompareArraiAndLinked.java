package lesson13;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class CompareArraiAndLinked {
    public static void main(String[] args) {


    List<Integer> arrayList=new ArrayList<Integer>();
    List<Integer> linkedList=new LinkedList<Integer>();

        System.out.println("Вставка в конец");

        System.out.println("ArrayList time");
long l=System.nanoTime();


for (int i=0;i<=5000; i++){
    arrayList.add(i);
}
        System.out.println(System.nanoTime()-l);


        System.out.println("Linkedlist time");
l=System.nanoTime();

for (int i=0;i<5000; i++){
    linkedList.add(i);
}
        System.out.println(System.nanoTime()-l);

//--------------------------------------
        System.out.println("вставка в элемент 2500");


        System.out.println("ArrayList time replace 2500");
        l=System.nanoTime();


        for (int i=0;i<=5000; i++){
            arrayList.add(2500,i);
        }
        System.out.println(System.nanoTime()-l);

        System.out.println("ArrayList time JIT replace 2500");
        l=System.nanoTime();


        for (int i=0;i<=5000; i++){
            linkedList.add(((linkedList.size()-linkedList.size()%2))/2,i);
        }
        System.out.println(System.nanoTime()-l);

        System.out.println("Linkedlist time replace 2500");
        l=System.nanoTime();

        for (int i=0;i<5000; i++){
            linkedList.add(2500,i);
        }
        System.out.println(System.nanoTime()-l);


        System.out.println("Linkedlist time JIT replace 2500");
        l=System.nanoTime();

        for (int i=0;i<5000; i++){
            linkedList.add(((linkedList.size()-linkedList.size()%2))/2,i);
        }
        System.out.println(System.nanoTime()-l);



    }}
