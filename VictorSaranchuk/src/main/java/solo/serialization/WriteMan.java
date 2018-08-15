package solo.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteMan {
    public static void main(String[] args) throws IOException {
     Man man=new Man();
     man.setName("Pavel");


     man.setAge(30);

        FileOutputStream fos=new FileOutputStream("man.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(man);
        oos.close();
        fos.close();



    }
}
