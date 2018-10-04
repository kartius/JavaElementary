package ua.od.hillel.lesson_16_serialization.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Address address;


        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        address = (Address) ois.readObject();
        ois.close();

        System.out.println(address.toString());


    }
}
