package lesson17HomeWork;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class StudentRunner {
    public static void main(String[] args) throws IOException, JAXBException {
        //Create data and File
        String studentStr="ID: 1\nLastName: Ivanov\nFirstName: Ivan\nAge: 20";
        File file=new File("student.txt");

        //Write to file data
        Writer.write(file.getPath(),studentStr);

        //Create Student object
        Student student=new Student();

        //Read data from file
        String c= Reader.read(file);
        System.out.println(c);

        //Show
        System.out.println(Reader.getIdFromFile(file));
        System.out.println(Reader.getLastNameFromFile(file));
        System.out.println(Reader.getFirstNameFromFile(file));
        System.out.println(Reader.getAgeFromFile(file));

        //Setters
        student.setId(Reader.getIdFromFile(file));
        student.setLastName(Reader.getLastNameFromFile(file));
        student.setFirstName(Reader.getFirstNameFromFile(file));
        student.setAge(Reader.getAgeFromFile(file));

        //Write in XML to student_out
        File file1=new File("student_out");
        JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student,file1);

        //Unmarshall from XML to Student object
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        student=(Student)unmarshaller.unmarshal(new File("student_out"));

        //Write student in JSon to file
        Writer.writeStudentInJsonToFile(student,file1);



    }
}
