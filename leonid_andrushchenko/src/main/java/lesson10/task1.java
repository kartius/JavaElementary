package lesson10;

public class task1 {
    public static void main(String[] args) {
        String str = "andrushchenkoleonid@gmail.com";
        str = str.replaceAll("\\.", "[dot]").replaceAll("@", "[ at ]");
        System.out.println(str);
    }



    public static String abridge(String str){
        char[] str_chars = str.toCharArray();
        if (str_chars.length < 4){
            return str;
        }


        StringBuilder stringBuilder = new StringBuilder();


        char[] middleSize = Integer.toString(str_chars.length - 2).toCharArray();// Вычисляет колличество букв между первой и последней, и превращает его в массив символов
        stringBuilder.setLength(middleSize.length + 2);

        stringBuilder.setCharAt(0, str_chars[0]);

        for(int i = 0; i < middleSize.length; i++){// Копирует число букв между первой и последней в слове посимвольно
            stringBuilder.setCharAt(i+1, middleSize[i]);
        }

        stringBuilder.setCharAt(stringBuilder.length() - 1, str_chars[str_chars.length - 1]);//  копирует последнюю букву в слове

        return stringBuilder.toString();
    }
}
