package lesson_11;

import java.io.Closeable;
import java.io.IOException;

public class Resource implements Closeable{



    @Override
    public void close() throws IOException {
        System.out.println("I want to be closed");
    }
}
