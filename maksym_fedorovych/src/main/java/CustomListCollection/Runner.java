package main.java.CustomListCollection;

public class Runner {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(10, "444");
        customArrayList.set(8, "add 8 value");
        customArrayList.remove(7);
        customArrayList.remove(23423);
        customArrayList.set(12, "add 12 value");
        customArrayList.set(13, "add 12 value");
        customArrayList.remove(13);
        customArrayList.remove("444");

        for (int i = 0; i < customArrayList.size(); i++) {
            {
                System.out.println("index " + i + " Значение " + customArrayList.get(i));

            }
        }

        System.out.println(customArrayList.get(11));

        System.out.println(customArrayList.indexOf("add 8") );
        System.out.println(customArrayList.indexOf("add 8 value") );
        customArrayList.clear();

        for (int i = 0; i < customArrayList.size(); i++) {
            {
                System.out.println("index " + i + " Значение " + customArrayList.get(i));

            }
        }


    }
}
