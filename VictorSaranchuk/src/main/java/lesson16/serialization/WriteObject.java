package lesson16.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) throws IOException {
        Adress adress=new Adress();
        adress.setStreet("Kanatnaya");
        adress.setCountry("Ukraine");

        FileOutputStream fout=new FileOutputStream("test.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(adress);
        oos.close();
    }
}
