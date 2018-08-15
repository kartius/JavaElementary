package solo.serialization.man;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadMan {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Object man;

        FileInputStream fis=new FileInputStream("man.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        man=ois.readObject();
        System.out.println(man.toString());
        ois.close();
        fis.close();

    }

}
