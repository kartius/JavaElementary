package main.java.HomeworkArray24072018;

import java.util.Scanner;

public class HomeworkArray {

    public void SetArray()
    {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите размерность массива");
       int n = scanner.nextInt();
       int[] arr1 = new int[n];
       int[] arr2 = new int[n];

       for (int i = 0; i < arr1.length; i++)
       {
           arr1[i] = i+1;
           arr2[i] = n -1;
       }

    }

}
