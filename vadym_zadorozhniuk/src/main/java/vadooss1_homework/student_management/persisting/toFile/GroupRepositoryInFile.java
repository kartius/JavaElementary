package vadooss1_homework.student_management.persisting.toFile;

import com.google.gson.Gson;
import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.persisting.GroupRepository;

import java.io.*;

public class GroupRepositoryInFile implements GroupRepository {

    int countGroups = 0;

    @Override
    public void add(Group group) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(group.id+"group.json"));
            PrintWriter pw2 = new PrintWriter(new FileWriter("amountGroup.txt"))){
            Gson js = new Gson();
            js.toJson(group, pw);
            countGroups++;
            pw2.write(String.valueOf(countGroups));

        }
        catch (IOException e){e.printStackTrace();}

    }

    @Override
    public Group get(int id) {
        Gson js = new Gson();
         try(BufferedReader br = new BufferedReader(new FileReader(id+"group.json"))) {
             return js.fromJson(br,Group.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public void del(int id) {
        try(PrintWriter pw2 = new PrintWriter(new FileWriter("amountGroup.txt"))
        ){File file = new File(id+"group.json");
        file.delete();
        countGroups--;
        pw2.write(String.valueOf(countGroups));
        }catch (IOException e){e.printStackTrace();}
    }

    @Override
    public int getAmountOfAvailableGroups() {
        String res="";
        try {
            BufferedReader br = new BufferedReader(new FileReader("amountGroup.txt"));
            res=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.valueOf(res);
    }

    @Override
    public void assignStudentToGroup(Group group, Student student) throws Exception {
        File file = new File(group.id+"group.json");
        if(file.exists()){
            student.groups.add(group.id);
            student.subjects.add(group.subject);
            group.addStudent(student);
            try(PrintWriter pw = new PrintWriter(new FileWriter(group.id+"group.json"))){
                Gson js = new Gson();
                js.toJson(group, pw);
                }
            catch (IOException e){e.printStackTrace();}
            StudentRepositoryInFile studentRepositoryInFile = new StudentRepositoryInFile();
            studentRepositoryInFile.add(student);
        }else{
            student.groups.add(group.id);
            student.subjects.add(group.subject);
            group.addStudent(student);
            add(group);
            StudentRepositoryInFile studentRepositoryInFile = new StudentRepositoryInFile();
            studentRepositoryInFile.add(student);
        }


    }
}
