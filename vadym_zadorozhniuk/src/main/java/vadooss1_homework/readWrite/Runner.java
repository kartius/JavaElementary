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
        fileStud.write("ID:1\nLastname:Sidorov\nFirstname:Ivan\nAge:20\n");
        fileStud.close();

        Student student = new Student();

        readFromTXT(student, "student.txt");
        System.out.println(student.toString());

        writeToXML(student, "student_out.xml");
        student = readFromXML("student_out.xml");
        System.out.println(student.toString());

        writeToJSON(student, "student_out.json");
        student = readFromJSON("student_out.json");
        System.out.println(student.toString());

    }

    static void readFromTXT(Student student, String filename) throws IOException {
        BufferedReader readStud = new BufferedReader(new FileReader(filename));
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

    static void writeToXML(Student student, String filename) throws JAXBException {
        File file  = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student, file);

    }
    static Student readFromXML(String filename) throws JAXBException {
        File file  = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Student) unmarshaller.unmarshal(file);

    }
    static void writeToJSON(Student student, String filename) throws IOException {
        Gson json = new Gson();
        FileWriter fileWriter = new FileWriter(filename);
        json.toJson(student, fileWriter);
        fileWriter.close();

    }
    static Student readFromJSON(String filename) throws IOException {
        Gson json = new Gson();
        FileReader fileReader = new FileReader(filename);
        Student student = json.fromJson(fileReader, Student.class);
        fileReader.close();
        return student;
    }

}
