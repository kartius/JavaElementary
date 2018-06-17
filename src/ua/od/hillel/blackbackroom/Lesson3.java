
import java.util.Scanner;
public class Lesson3 {
    public static void main(String[] args) {
        //Сканер значения факториала
        System.out.println("Введите значение факториала");
        Scanner scanner=new Scanner(System.in);
        int end=scanner.nextInt();
        //Начальное значение факториала fibonaci
        int fact=1;
        //Цикл для расчёта факториала
        for(int i=1;i<end;i++){
            fact*=(i+1);
        }
        //Вывод на экран результата
        System.out.println("Факториал "+end+" равен: "+fact);



        System.out.println("Введите количество чисел Фибоначчи для вывода:");
        //Сканируем количесство чисел для вывода
        int i=scanner.nextInt();
        //Создаём массив Фибоначчи
        int[] fibonachi=new int[i];
        //Указываем первые два значение массива
        fibonachi[0]=0;
        fibonachi[1]=1;
        System.out.print("Ряд Фибоначчи для первых "+i+" элементов: "+fibonachi[0]+" "+fibonachi[1]+" ");
        //Через цикл выводим
        for( i=2;i<fibonachi.length;i++){
            fibonachi[i]=fibonachi[i-1]+fibonachi[i-2];
            System.out.print(fibonachi[i]+" ");
        }

    }


}
