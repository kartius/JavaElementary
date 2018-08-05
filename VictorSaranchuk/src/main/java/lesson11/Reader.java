package lesson11;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
public void read(String str) {
    try{
        FileReader fileReader=new FileReader(str);

    }catch (FileNotFoundException e){
        System.out.println("test");
        e.printStackTrace();
    }
}
}
