package ua.od.hillel.leonid_andrushchenko.lesson_2;

public class task_2 {
    public static String task2(String word)
    {
        word = word.replace('1', '2');
         word = word.replaceAll("n", "n ");
        return word;
    }
}
