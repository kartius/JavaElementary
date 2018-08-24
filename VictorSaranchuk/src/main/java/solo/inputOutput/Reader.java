package solo.inputOutput;

import java.io.*;

public class Reader {


    public static void reader(String file, Student student) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String[] str=br.readLine().split(":");
        int id=Integer.parseInt(str[1].trim());
        student.setId(id);

        str=br.readLine().split(":");
        String lastName=str[1].trim();
        student.setLastName(lastName);

        str=br.readLine().split(":");
        String firstName=str[1].trim();
        student.setFirstName(firstName);

        str=br.readLine().split(":");
        int age=Integer.parseInt(str[1].trim());
        student.setAge(age);

        br.close();
        fr.close();

    }

}
