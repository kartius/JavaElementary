package lesson4HomeWork;
import java.util.Scanner;
public class Converter {

    // Вводим константу курс доллара
    static final double kursDoll=26.3;

    // создаю статический метод конвертации валют
    public static void conv(){
        System.out.println("Введите сумму в долларах");
        Scanner sc=new Scanner(System.in);
        double valuta=sc.nextDouble();
        /*
        * Нужно окончание целочислительного для окончания фразы.
        * */
        String cel=Integer.toString((int)(valuta*kursDoll));
        char[] arr1=cel.toCharArray();
        String end;
        switch(arr1[arr1.length-1]){
            case 1: end=" гривна";
            break;
            case 2: case 3: case 4: end=" гривны";
            break;
            default: end=" гривен";
            break;
        }

        System.out.println("Конвертация в гривну: "+valuta*kursDoll+end);

    }
// в мэне вывожу метод конвертации
    public static void main(String[] args) {
        Converter.conv();
    }
}
