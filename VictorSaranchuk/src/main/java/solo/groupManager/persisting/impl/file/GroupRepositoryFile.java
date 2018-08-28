package solo.groupManager.persisting.impl.file;


import solo.groupManager.model.Group;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.GroupRepository;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryFile implements GroupRepository {
    final static Logger logger=Logger.getLogger(GroupRepositoryFile.class);
    private final String GROUP_ID="group_id";
    private final String GROUP_SUBJECT_NAME="group_subject_name";
    private final String GROUP_IS_AVAILABLE="is_available";
    private final String STUDENTS_LIST="students_list";
    private final String STUDENT_ONE="student_one";
    private final String STUDENT_ID="student_id";
    private final String STUDENT_NAME="student_name";

    @Override
    public void assignStudentToGroup(Group group, Student student) {

    }

    @Override
    public int getAmountofAvailableGroups() {
        int count=0;
        String currentLine;
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("groups.txt"))){
            while((currentLine=bufferedReader.readLine())!=null){
                if(getValue(GROUP_IS_AVAILABLE,currentLine).equalsIgnoreCase("true")){
                    count++;
                }
            }
        }catch (IOException e){
            logger.error("Get amount of available groups throws ex: "+e);
        }
        return count;
    }

    @Override
    public void add(Group group) {
        try(PrintWriter printWriter=new PrintWriter(new FileWriter("group.txt", true))){
            StringBuilder sb=new StringBuilder();
            sb.append(GROUP_ID).append(group.getId()).append(GROUP_ID)
                    .append(GROUP_SUBJECT_NAME).append(group.getSubject().getName()).append(GROUP_SUBJECT_NAME)
                    .append(STUDENTS_LIST);
            for (Student student:group.getStudents()){
                sb.append(STUDENT_ONE)
                        .append(STUDENT_ID).append(student.getId()).append(STUDENT_ID)
                        .append(STUDENT_NAME).append(student.getName()).append(STUDENT_NAME)
                        .append(STUDENT_ONE);
            }
            sb.append(STUDENTS_LIST).append(GROUP_IS_AVAILABLE).append(group.isAvailable()).append(GROUP_IS_AVAILABLE);
            sb.append("FinishLine");
            printWriter.println(sb);
            printWriter.flush();
        }catch (IOException e){
            logger.error("Add group throws ex: "+e);
        }
    }

    @Override
    public void delete(int id) {
        List<String> groups=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("groups.txt"))){
            String currentLine;
            while((currentLine=bufferedReader.readLine())!=null){
                if(!getValue(GROUP_ID,currentLine).equals(String.valueOf(id))){
                    groups.add(currentLine);
                }
            }
        }catch (IOException e){
            logger.error("Delete group throws ex: "+e);
        }
        try(PrintWriter printWriter=new PrintWriter(new FileWriter("groups.txt"))){
            for(String group:groups){
                printWriter.println(group);
            }
            printWriter.flush();
        }
        catch (IOException e){
            logger.error("Delete group throws ex: "+e);
        }

    }

    @Override
    public void update(Group group) {
        int id=group.getId();
        delete(id);
        add(group);

    }

    @Override
    public Group get(int id) {
        Group group=new Group();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("group.txt"))){
            String currentLine;
            while ((currentLine=bufferedReader.readLine())!=null){
                if(getValue(GROUP_ID,currentLine).equals(String.valueOf(id))){
                group.setId(id);
                    Subject subject=new Subject(getValue(GROUP_SUBJECT_NAME,currentLine));
                group.setSubject(subject);
                String students_list=getValue(STUDENTS_LIST,currentLine);
                String[] students=getValues(STUDENT_ONE, students_list);
                List<Student> studentList=new ArrayList<>();
                    for (String studentOne:students) {
                        Student student=new Student();
                        student.setId(Integer.valueOf(getValue(STUDENT_ID,studentOne)));
                        student.setName(getValue(STUDENT_NAME, studentOne));
                        studentList.add(student);
                    }
                    group.setStudents(studentList);
                }
            }
        }catch (IOException e){
            logger.error("Get group throws ex: "+e);
        }
        return group;
    }
    private String getValue(String value, String target){
        String result=null;
        String[] values=target.split(value);
        if(values.length==3){
            result=values[1];
        }
        return result;
    }
    private String[] getValues(String value,String target){
        String[]values = target.split(value);
        return values;
    }
}
