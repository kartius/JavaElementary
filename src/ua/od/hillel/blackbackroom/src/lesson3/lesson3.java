package lesson3;
import java.util.Scanner;
public class lesson3 {
    public static void main(String[] args) {
        //Сканер значения факториала
        System.out.println("Введите значение факториала");
        Scanner scanner=new Scanner(System.in);
        int end=scanner.nextInt();
        //Начальное значение факториала
        int fact=1;
        //Цикл для расчёта факториала
        for(int i=1;i<end;i++){
            fact*=(i+1);
        }
        //Вывод на экран результата
        System.out.println("Факториал "+end+" равен: "+fact);
    }
    
}
