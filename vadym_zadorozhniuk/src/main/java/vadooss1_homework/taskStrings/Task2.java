package vadooss1_homework.taskStrings;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);
        String userEnter;

        System.out.print("Enter just letters in words through space -> ");
        while (ms.hasNextInt()) {
            System.out.print("Error! Enter only letters -> ");
            ms.nextLine();
        }
        userEnter = ms.nextLine();

        System.out.println(shortForm(userEnter));

    }

    static String shortForm(String userEnter) {
        String result = "";
        int count;
        for (int i = 0; i < userEnter.length(); i++) {
            count = 0;
            if (userEnter.charAt(i) != ' ') {
                result += userEnter.charAt(i);
                i++;
                while (i < userEnter.length() && userEnter.charAt(i) != ' ') {
                    count++;
                    i++;

                }
                if (count < 3 && count > 0) {
                    for (int j = 0; j < count; j++) {
                        result += userEnter.charAt(i - count + j);
                    }
                    result += " ";
                } else if (count >= 3) {
                    result += (count - 1) + "" + userEnter.charAt(i - 1) + " ";
                } else {
                    result += " ";
                }

            }

        }
        return result;

    }
}
