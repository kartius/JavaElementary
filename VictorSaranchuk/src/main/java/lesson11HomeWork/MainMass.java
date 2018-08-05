package lesson11HomeWork;
import java.util.Scanner;

public class MainMass {

    public static void main(String[] args) {

        System.out.println("Enter int");
        Scanner scanner=new Scanner(System.in);//Сканнер считывает тут

        if (!scanner.hasNextInt()){
            System.out.println("This is not int");
        } else{
            int length=scanner.nextInt();

            Mass.makeMass(length);

            Mass.reverseMass(length);

            Mass.divThree(length);

            Mass.divTwo(length);

            System.out.println("Сумма элементов массива");
            System.out.print(Mass.sumElements(length));
            System.out.println("\n=============================");

            System.out.println("Среднее арифметическое элементов массива");
            System.out.println(Mass.avg(length, Mass.sumElements(length)));
            System.out.println("\n=============================");

            Mass.minMax(length);

            Mass.multnechet(length);

            System.out.println("Enter number to search index");
            int number;
            if (!scanner.hasNextInt()){
                System.out.println("This is not int");
            } else{number=scanner.nextInt();
            Mass.searchNumber(length, number);

            }

        }



            }
}
