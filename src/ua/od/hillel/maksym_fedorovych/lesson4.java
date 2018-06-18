package ua.od.hillel.maksym_fedorovych;

import java.util.Arrays;

public class lesson4 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int arr2[] = {3,5,6,7};
        for (int i = 0; i < arr2.length; i++)
        {
            System.out.println(arr2[i]);
        }
        System.out.println("-------------");

        for (int i: arr2) {
            System.out.println(i);
        }

        int[] arr3 = {3,6,9};
        int[] arr4 = arr3;
        for (int i : arr3){
             System.out.println(i);
        }

        for (int i : arr4){
            System.out.println(i);
        }

        int arr5[] = Arrays.copyOf(arr3,3);


        System.out.println(
        Arrays.toString(arr5));
        int[] arr6 = new int[arr2.length + arr3.length];
        System.arraycopy(arr2, 0, arr6, 0, arr2.length);
        System.arraycopy(arr3, 0, arr6, arr2.length, arr3.length);

        System.out.println(Arrays.toString(arr6));

        int[][] arr7 = new int[3][4];
        int c = 0;
        for (int i = 0; i<3; i++){
            for (int j = 0; j < 4; j++){
                arr7[i][j] = c;
                c++;
            }
        }
        System.out.println(Arrays.deepToString(arr7));
        System.out.println(arr7.length);
        System.out.println(arr7[0].length);
    }
}
