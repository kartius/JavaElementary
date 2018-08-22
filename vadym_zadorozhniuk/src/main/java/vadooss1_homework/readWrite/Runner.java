package vadooss1_homework.readWrite;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Runner {
    public static void main(String[] args) throws IOException, JAXBException {
        PrintWriter fileStud = new PrintWriter(new FileWriter("student.txt"));
        fileStud.write("ID:1\nLastname:Sidorov\nFirstname:Ivan\nAge:20");
        fileStud.close();
        File file  = new File("student_out.xml");

        Student student = new Student();

        readFromTXT(student);
        System.out.println(student.toString());

        writeToXML(student, file);
        readFromXML(student, file);
        System.out.println(student.toString());
        writeToJSON(student);

    }

    static void readFromTXT(Student student) throws IOException {
        BufferedReader readStud = new BufferedReader(new FileReader("student.txt"));
        String str;
        str=readStud.readLine();
        student.setId(Integer.parseInt(str.substring(str.indexOf(":")+1).trim()));
        str=readStud.readLine();
        student.setLastname(str.substring(str.indexOf(":")+1).trim());
        str=readStud.readLine();
        student.setFirstname(str.substring(str.indexOf(":")+1).trim());
        str=readStud.readLine();
        student.setAge(Integer.parseInt(str.substring(str.indexOf(":")+1).trim()));
        readStud.close();
    }

    static void writeToXML(Student student, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student, file);

    }
    static void readFromXML(Student student, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        student = (Student) unmarshaller.unmarshal(file);

    }
    static void writeToJSON(Student student) throws IOException {
        Gson json = new Gson();
        FileWriter fileWriter = new FileWriter("student_out.json");
        json.toJson(student, fileWriter);
        fileWriter.close();

    }

}
