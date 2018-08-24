package vadooss1_homework.student_management.persisting.toFile;

import com.google.gson.Gson;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;
import vadooss1_homework.student_management.persisting.StudentRepository;

import java.io.*;
import java.util.LinkedList;

public class StudentRepositoryInFile implements StudentRepository  {

    @Override
    public void add(Student student) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(student.id+"student.json"))){
            Gson js = new Gson();
            js.toJson(student, pw);
        }
        catch (IOException e){e.printStackTrace();}

    }

    @Override
    public Student get(int id) {
        Gson js = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(id+"student.json"))) {
            return js.fromJson(br,Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void del(int id) {
        File file = new File(id+"student.json");
        file.delete();
    }

    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
        Gson js = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(student.id+"student.json"))) {
            return js.fromJson(br,Student.class).schoolClassLevel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public LinkedList<Subject> getAllSubjects(Student student) {
        Gson js = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(student.id+"student.json"))) {
            return js.fromJson(br,Student.class).subjects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
