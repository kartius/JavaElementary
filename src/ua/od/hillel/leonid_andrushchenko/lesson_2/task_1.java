package ua.od.hillel.leonid_andrushchenko.lesson_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task_1 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите Ваш вес в килограммах: ");
        double weight = Double.parseDouble(reader.readLine());
        System.out.println("Ваш вес на Луне составит " + weight*0.17 + " кг.");

    }
}
