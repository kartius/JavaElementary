package solo.inputOutput;

import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        Student student=new Student();
        String file="student.txt";
        Reader.reader(file, student);
        System.out.println(student.getAge()+" "+student.getId()+" "+student.getFirstName()+" "+
        student.getLastName());



    }
}
