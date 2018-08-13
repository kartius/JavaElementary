package ua.od.hillel.lesson_16.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {


    public static void main(String[] args) throws IOException {




        Address address = new Address();
        address.setStreet("Kanatnaya");
        address.setCountry("Ukraine");

        FileOutputStream fout = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(address);
        oos.close();





    }
}
