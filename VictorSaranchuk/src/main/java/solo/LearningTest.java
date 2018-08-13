package solo;


import java.util.Arrays;
import java.util.Random;

public class LearningTest {
    public static void main(String[] args) {

        String[] arr={"1","2","3","4","5"};
        LearningTest.shuffle(arr);

        for (String s:arr
             ) {
            System.out.print(s+" ");
        }


    }


    public  static void shuffle(String[] array){
        Random random=new Random(System.nanoTime());
        for(int i=0; i<array.length; i++){
        swap(array, i, random.nextInt(array.length));
        }
    }

    public static void swap(String[] arr, int i, int j){
        String tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


}
