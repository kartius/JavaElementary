package lesson16.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Adress adress;

        FileInputStream fin=new FileInputStream("test.txt");
        ObjectInputStream ois=new ObjectInputStream(fin);
        adress=(Adress) ois.readObject();

        ois.close();

        System.out.println(adress.toString());
    }
}
