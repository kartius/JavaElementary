package lesson17.task1;

import java.io.*;

public class Banchmark {
    public static void main(String[] args) throws IOException {
        // Initialization of all streams
        File file = new File("C:\\Users\\ASUS\\Desktop\\Leonid.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);


        System.out.println("Throw 1 iteration");


        System.out.println("\n FileInputStream realization");
        long startTime = System.nanoTime();
        fileInputStream.read();
        System.out.println(System.nanoTime() - startTime);


        System.out.println("\n BufferedInputStream realization");
        startTime = System.nanoTime();
        bufferedInputStream.read();
        System.out.println(System.nanoTime() - startTime);


        System.out.println("\n ------------- \n");


        System.out.println("Throw 1000 iterations");


        System.out.println("\n FileInputStream realization");
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            fileInputStream.read();
        }
        System.out.println(System.nanoTime() - startTime);



        System.out.println("\n BufferedInputStream realization");
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            bufferedInputStream.read();
        }
        System.out.println(System.nanoTime() - startTime);

        bufferedInputStream.close();
        fileInputStream.close();
    }
}
