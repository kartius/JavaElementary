package vadooss1_homework.taskArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TaskArrays {
    public static void main(String[] args) throws InputExceptions {
        Scanner ms = new Scanner(System.in);
        int userEnter;
        int n = 10;

        first5elements(n);
        System.out.println();
        int[] array1 = arraysGeneration_1toN(n);
        System.out.println(Arrays.toString(array1));
        int[] array2 = arraysGeneration_Nto1(n);
        System.out.println(Arrays.toString(array2));
        printElementsDivide_3(array1);
        System.out.println();
        printEven(array1);
        System.out.println();
        System.out.println(sumElements(array1));
        System.out.println(average(array1));
        System.out.println(minSumsmax(array1));
        System.out.println(getMultiplyUneven(array1));

        System.out.print("Enter integer -> ");
        userEnter = ms.nextInt();
//        try{ms.nextInt();}catch (InputExceptions e){
//            throw new InputExceptions("It is not integer");
//            System.err.println(e.getMessage());
//        }
        if(getIndexElement(userEnter, array1)==-1){
            throw new InputExceptions("The element no exist in the array");
            }

        System.out.println("Index of the digit is "+getIndexElement(userEnter, array1));

    }
    static void first5elements(int n){
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }
        for (int i = 0; i < array.length/2; i++){
            System.out.print(array[i]+", ");
        }
    }

    static int[] arraysGeneration_1toN(int n){
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }
        return array;

    }

    static int[] arraysGeneration_Nto1(int n){
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]=n-i;
        }
        return array;

    }

    static void printElementsDivide_3(int[] array){
        for (int i : array) {
            if(i%3==0){
                System.out.print(i+", ");
            }
        }
    }

    static void printEven(int[] array){
        for (int i : array) {
            if(i%2==0){
                System.out.print(i+", ");
            }
        }
    }

    static int sumElements(int[] array){
        int sum = 0;
        for (int i : array) {
           sum+=i;
        }
        return sum;
    }

    static int average(int[] array){
        int sum = 0;
        for (int i : array) {
            sum+=i;
        }
        return sum/array.length;
    }
    static int minSumsmax(int[] array){
        int min=array[0];
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }else if(array[i]<min){
                min=array[i];
            }
        }
        return min+max;
    }

    static int getMultiplyUneven(int[] array){
        int multiply=1;
        for (int i : array) {
            if(i%2!=0){
                multiply*=i;
            }
        }
        return multiply;
    }

    static int getIndexElement(int userEnter, int[] array){
        int count=0;
        boolean hasElement=false;
        for (int i:array){
            count++;
            if(userEnter==i){
                hasElement=true;
                break;
            }
        }
        if(!hasElement) {
            return -1;
        }else{
        return --count;}
    }
}
