package ua.od.hillel.nick_tsyb.lesson4;

import java.util.Arrays;

public class ArraysLesson {


    public static void main(String[] args) {

        System.out.println("Start lesson 4  ");


//        int[] arr1 = new int[10];
//
//        int arr2[] = {3, 5, 6, 7};
//
//        for (int i = 0; i <arr2.length ; i++) {
//            System.out.println(arr2[i]);
//
//        }
//
//        System.out.println("-------------");
//
//        for (int i : arr2) {
//            System.out.println(i);
//        }

//        int[] arr1 = {3, 6, 9};
//
//        int[] arr2 = arr1;
//
//        for (int i : arr1) {
//            System.out.println(i);
//
//        }
//
//        System.out.println("------------");
//
//        for (int i : arr2) {
//            System.out.println(i);
//        }
//
//
//        arr2[0]=10;
//
//        System.out.println("Change element in array arr2");
//
//
//        for (int i : arr2) {
//            System.out.println(i);
//        }
//
//
//        System.out.println("arr1");
//
//
//        for (int i : arr1) {
//            System.out.println(i);
//        }


//        int[] arr1 = {3, 6, 9};
//
//        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
//
//
//        System.out.println(Arrays.toString(arr2));

//        int[] arr1 = {3, 6, 9};
//        int[] arr2 = {5, 11, 19};
//
//        int[] arr3 = new int[arr1.length + arr2.length];
//
//
//        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
//
//        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
//
//        System.out.println(Arrays.toString(arr3));


        int[][] arr1 = new int[3][4];

        int c = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                arr1[i][j] = c;
                c++;

            }

        }

        System.out.println(Arrays.deepToString(arr1));

        System.out.println(arr1.length);
        System.out.println(arr1[0].length);



    }
}
