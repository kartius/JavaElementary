package lesson17.task2;

import java.io.*;
import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        Student student = new Student();
        student.setID(1);
        student.setFirstname("Leonid");
        student.setLastname("Andrushchenko");
        student.setAge(22);


        File file = new File("Student.txt");
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(student);
        oos.close();


        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Student student1 = (Student) ois.readObject();
        ois.close();


        file = new File("student_out.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(student1, file);


        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Student student2 = (Student) jaxbUnmarshaller.unmarshal(file);

        file = new File("student_out.json");
        Gson gson = new Gson();


        try (FileWriter fileWriter = new FileWriter(file)){
            gson.toJson(student2, fileWriter);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
