package vadooss1_homework.readWrite;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckSpeed {
    public static void main(String[] args) throws IOException {
        long l = System.nanoTime();
        BufferedInputStream b = new BufferedInputStream(new FileInputStream("D:\\JavaElementary\\vadym_zadorozhniuk\\src\\main\\java\\vadooss1_homework\\readWrite\\im.png"));
        int i;
        while ((i=b.read())!=-1){}
        System.out.print("BufferedInputStream result - ");
        System.out.println(System.nanoTime()-l);

        l = System.nanoTime();
        FileInputStream f = new FileInputStream("D:\\JavaElementary\\vadym_zadorozhniuk\\src\\main\\java\\vadooss1_homework\\readWrite\\im.png");
        int k;
        while ((k=f.read())!=-1){}
        System.out.print("FileInputStream - \t\t\t");
        System.out.println(System.nanoTime()-l);


    }
}
