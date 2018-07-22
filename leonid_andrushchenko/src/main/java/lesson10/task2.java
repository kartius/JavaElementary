package lesson10;

public class task2 {
    public static void main(String[] args) {
        String str = "internationalization localization cat elephant monitor";
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++){
            System.out.print(abridge(words[i]) + " ");
        }
    }

    public static String abridge(String str){// Сокращает отдельные слова
        if (str.length() < 4){
            return str;
        }


        StringBuilder stringBuilder = new StringBuilder();


        char[] middleSize = Integer.toString(str.length() - 2).toCharArray();// Вычисляет колличество букв между первой и последней, и превращает его в массив символов
        stringBuilder.setLength(middleSize.length + 2);

        stringBuilder.setCharAt(0, str.charAt(0));

        for(int i = 0; i < middleSize.length; i++){// Копирует число букв между первой и последней в слове посимвольно
            stringBuilder.setCharAt(i+1, middleSize[i]);
        }

        stringBuilder.setCharAt(stringBuilder.length() - 1, str.charAt(str.length() - 1));//  копирует последнюю букву в слове

        return stringBuilder.toString();
    }
}
