package lesson4;

import java.util.Arrays;

public class Lesson4 {
    public static void main(String[] args) {
        System.out.println("Start Lesson4");
//        int[] arr1=new int[10];
//        int arr2[]={23,5,6,7};
//        for(int i=0;i< arr1.length;i++){
//            System.out.print(arr2[i]);
//        }
//        System.out.println("-----------------------");
//        for(int i:arr2){
//            System.out.print(i);
//        }
//        int[] arr1={3,6,9};
//        int[] arr2=arr1;
//        for(int i:arr1){
//            System.out.println(i);
//        }
//        System.out.println("-----------------------");
//        for (int i : arr2) {
//            System.out.println(i);
//        }
//        arr2[0]=10;
//        System.out.println("Change array 2");
//        for (int i : arr2) {
//            System.out.println(i);
//        }

//        int[] arr1={3,6,9};
//        int[] arr2= Arrays.copyOf(arr1,3);
//        System.out.println(Arrays.toString(arr2));
//
//        int[] arr1={2,6,9};
//        int[] arr2={5,11,77};
//
//        int[] arr3=new int[arr1.length+arr2.length];
//        System.arraycopy(arr1,0,arr3,0,arr1.length);
//        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
//        System.out.println(Arrays.toString(arr3));

        int[][] arr1=new int[3][4];
        int c=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<4;j++){
                arr1[i][j]=c;
                c++;
            }
        }
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(arr1.length);
        System.out.println(arr1[0].length);
    }
}

