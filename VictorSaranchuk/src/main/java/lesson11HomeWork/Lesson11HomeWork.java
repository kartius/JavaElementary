package lesson11HomeWork;
import java.util.Arrays;
import java.util.Scanner;


public class Lesson11HomeWork {

    public static void main(String[] args) {

//    Выведите первые 5 элементов массива, у которого размер 10
        System.out.println("Выведите первые 5 элементов массива, у которого размер 10");
        int[] massive_first=new int[10];
        for (int i=0; i<5; i++){
            System.out.print(massive_first[i]+" ");}
        System.out.println("\n=============================");

//    Создайте массив размером n, элементами, которого будут числа от 1 до n
        System.out.println("Введите значение количества смивовлов в массиве от 1 до n");
        Scanner scanner=new Scanner(System.in);

        if (!scanner.hasNextInt()){System.out.println("Это не целое число");}

        int length=scanner.nextInt();
        int[] array=new int[length];
            System.out.println("Массив от 1 до "+length+": ");
        for (int i=0; i<length; i++){
            array[i]=i+1;
            System.out.print(array[i]+" ");}

        System.out.println("\n=============================");

//    Создайте массив размером n, элементами которого будут числа от n до 1
        System.out.println("Инверсия массива от 1 до "+length+":");
        int[] sort=new int[length];
        for(int i=(length-1);i>=0;i--){
            sort[(length-1-i)]=array[i];
            System.out.print(sort[length-1-i]+" ");
        }
        System.out.println("\n=============================");

//    Выведите элементы массива, которые делятся на 3 без остатка
        System.out.println("Элементы мыссива, которые делятся на 3 без остатка");
        for (int i:array
             ) {
            if(i%3==0){
                System.out.print(i+" ");
            }
        }

        System.out.println("\n=============================");

//    Выведите все четные элементы массива
        System.out.println("Чётные элемены мыссива");
        for (int i:array
                ) {
            if(i%2==0){
                System.out.print(i+" ");
            }
        }

        System.out.println("\n=============================");

//    Найдите сумму элементов массива
        System.out.println("Сумма элементов массива");
        int count=0;
        for (int i:array
             ) {
            count+=i;
        }
        System.out.println(count);
        System.out.println("\n=============================");

//    Найдите среднее арифметическое элементов массива
        double avg=(double)count/length;
        System.out.println("Среднее арифметическое элементов массива: \n"+avg);
        System.out.println("\n=============================");

//    Определите сумму минимального и максимального элементов массива
        System.out.println("Сума минимального и максимального элементов массива:");
        int min=array[0];
        int max=array[0];
        for(int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }
        System.out.println(min+max);
        System.out.println("\n=============================");

//    Определите произведение всех нечетных элементов массива
        System.out.println("Произведение нечётных элементов массива:");
        long nechet=1;
        for (int i:array
             ) {
            if(i%2!=0){nechet*=i;}
        }
        System.out.println(nechet);
        System.out.println("\n=============================");

//    Определите позицию (индекс) элемента с числом n
        System.out.println("Введите число, индекс которого необходимо определить:");
        int number=scanner.nextInt();
        int index;
        for (int i=0; i<array.length; i++){
            if(number==array[i]){

                System.out.println("Индекс числа "+array[i]+": "+i);
            }
        }
        System.out.println("\n=============================");

//    Используйте Scanner для ввода необходимой информации
//    Так же создайте свои классы исключений и обработайте возможное исключительные ситуации
//   (К примеру, если элемент в массиве не найден или вводимые
//    значения не соответсвуют типу данных)


        }

}
