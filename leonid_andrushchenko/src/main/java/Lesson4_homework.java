import java.util.Scanner;

public class Lesson4_homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста введите название Вашей изначальной валюты из данного списка: USD, EUR, RUB.");
        String currency1 = scanner.nextLine();
        System.out.println("Теперь введите сумму, которую хотите конвертировать в гривну.");
        float sum = scanner.nextFloat();


        Converter converter = new Converter();
        converter.convert(currency1, sum);
    }
}
