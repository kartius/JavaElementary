package solo.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadMan {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Man2 man2;


        FileInputStream fis=new FileInputStream("man.txt");
        ObjectInputStream ois= new ObjectInputStream(fis);
        man2= (Man) ois.readObject();
        System.out.println(man2.toString());

        ois.close();
        fis.close();
    }
}
