package ua.od.hillel.leonid_andrushchenko;

public class Lesson3_homework {
    public static void main(String[] args)
    {
    }

    public static int task_1(int number)
    {
        int result = 1;
        for (int i = 2; i <= number; i++)
        {
            result *= i;
        }
        return result;
    }

    public static void task_2()
    {
        // выводит на экран первые 40 чисел последовательности Фибоначчи
        int firstNumber = 0;
        System.out.println("1) " + firstNumber);
        int secondNumber = 1;
        System.out.println("2) " + secondNumber);

        for (int i = 3; i <= 40; i++)
        {
            secondNumber += firstNumber;
           System.out.println(i + ") " + secondNumber);
           firstNumber = secondNumber - firstNumber;
        }

    }
}
