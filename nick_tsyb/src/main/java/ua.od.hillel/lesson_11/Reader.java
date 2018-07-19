package lesson_11;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {


    public void read(String str) throws GroupSizeLimitException {
        try {
            FileReader fileReader = new FileReader(str);
        } catch (FileNotFoundException e) {
            throw new GroupSizeLimitException(e.getMessage());
        }

    }

}
