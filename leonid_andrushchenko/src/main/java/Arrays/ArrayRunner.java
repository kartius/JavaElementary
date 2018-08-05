package Arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayRunner{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("task2");
        System.out.println("Введите натуральное число");

        int[] array1 = new int[0];
        int[] array2 = new int[0];

        try {
            int n = scanner.nextInt();
            array1  = task2(n);
            System.out.println("----------");
            System.out.println("task3");
            array2 = task3(n);
        }
        catch (Exception e){
            System.out.println("Вы ввели некорректное число. Пожалуйста попробуйте еще раз");
            main(args);
        }

        System.out.println("----------");
        System.out.println("task1");

        try{
            task1(array1);
        }
        catch (IncorrectArraySizeException e){
            System.out.println("array length must be 10");
        }

        System.out.println("----------");
        System.out.println("task4");

        task4(array1);

        System.out.println("----------");
        System.out.println("task5");

        task5(array1);

        System.out.println("----------");
        System.out.println("task6");

        System.out.println(task6(array1));

        System.out.println("----------");
        System.out.println("task7");

        System.out.println(task7(array1));

        System.out.println("----------");
        System.out.println("task8");

        System.out.println(task8(array1));

        System.out.println("----------");
        System.out.println("task9");

        System.out.println(task9(array1));

        System.out.println("----------");
        System.out.println("task10");

        System.out.println("Write number from array");

        try{
            int element = scanner.nextInt();
            System.out.println(task10(array1, element));
        }
        catch (ElementNotFoundException e){
            System.out.println("This is not array's element");
        }
        catch (InputMismatchException e){
            System.out.println("You must write a number");
        }
    }

    public static void task1(int[] array) throws IncorrectArraySizeException// Вывoдит первые 5 элементов массива, у которого размер 10
    {
        if(array.length != 10)
            throw new IncorrectArraySizeException("The length of array must be 10");
        for (int i = 0; i < 5; i++){
            System.out.println(array[i]);
        }
    }

    public static int[] task2(int n){// Создаcт массив размером n, элементами, которого будут числа от 1 до n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
            System.out.println(array[i]);
        }

        return array;
    }

    public static int[] task3(int n){// Создаcт массив размером n, элементами которого будут числа от n до 1
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
            System.out.println(array[i]);
        }
        return array;
    }
    public static void task4(int[] array){// Вывoдит элементы массива, которые делятся на 3 без остатка
        for(int number : array){
            if(number%3 == 0)
                System.out.println(number);
        }
    }

    public static void task5(int[] array){// Вывoдит все четные элементы массива
        for (int number : array){
            if (number%2 == 0){
                System.out.println(number);
            }
        }
    }

    public static int task6(int[] array){// Наxoдит сумму элементов массива
        int sum = 0;

        for (int number : array){
            sum += number;
        }

        return sum;
    }

    public static int task7(int[] array){// Наxoдит среднее арифметическое элементов массива
        return task6(array)/array.length;
    }

    public static int task8(int[] array){// Определит сумму минимального и максимального элементов массива
        int min = array[0];
        int max = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] < min)
                min = array[i];

            if(array[i] > max)
                max = array[i];
        }

        return min + max;
    }

    public static int task9(int[] array){//Определит произведение всех нечетных элементов массива
        int product = 1;

        for (int number : array){
            if (number%2 != 0)
                product*= number;
        }

        return product;
    }

    public static int task10(int[] array, int n)throws ElementNotFoundException// Определит позицию (индекс) элемента с числом n
    {
        for(int i = 0; i < array.length; i++){
            if(array[i] == n){
                return i;
            }
        }

        throw new ElementNotFoundException("It is not an element of this array");
    }
}
