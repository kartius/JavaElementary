package solo.groupManager.persisting.impl.file;

import org.apache.log4j.Logger;
import solo.groupManager.model.Group;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.GroupRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GroupRepositoryFile implements GroupRepository {
    final static Logger logger=Logger.getLogger(GroupRepositoryFile.class);
    private final static String STUDENT_ID="student_id";
    private final static String STUDENT_NAME="student_name";
    private final static String CLASS_LEVEL="class_level";
    private final static String SUBJECTS_LIST="subjects_list";
    private final static String SUBJECT_NAME="subject_name";
    private final static String GROUP_ID="group_id";
    private final static String GROUP_SUBJECT_NAME="group_subject_name";
    private final static String GROUP_IS_AVAILABLE="is_available";
    private final static String STUDETS_LIST="students_list";
    @Override
    public void assignStudentToGroup(Group group, Student student) {

    }

    @Override
    public int getAmountofAvailableGroups() {
        int i=0;
        String s=GROUP_IS_AVAILABLE+"true"+GROUP_IS_AVAILABLE;
        List<Group> groupsAvailable=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("groups.txt"))){
            String currentLine;
            while ((currentLine=bufferedReader.readLine())!=null){
                if(currentLine.contains(s)){
                    i++;
                }
            }
        }catch (IOException e){
            logger.error("getAmountOfAvailableGropups throws ex: "+e);
        }
        return i;
    }

    @Override
    public void add(Group group) {
        try(PrintWriter printWriter=new PrintWriter(new FileWriter("groups.txt", true))){
            StringBuilder sb=new StringBuilder();
            sb.append(GROUP_ID).append(group.getId()).append(GROUP_ID)
                    .append(GROUP_SUBJECT_NAME).append(group.getSubject().getName()).append(GROUP_SUBJECT_NAME)
                    .append(GROUP_IS_AVAILABLE).append(group.isAvailable()).append(GROUP_IS_AVAILABLE)
                    .append(STUDETS_LIST);
            for(Student student:group.getStudents()){
                sb.append(STUDENT_ID).append(student.getId()).append(STUDENT_ID)
                        .append(STUDENT_NAME).append(student.getName()).append(STUDENT_NAME).append(STUDETS_LIST)
                        .append(CLASS_LEVEL).append(student.getSchoolClass().getLevel()).append(CLASS_LEVEL);
            }
            sb.append("finishLine");
            printWriter.println(sb);
            printWriter.flush();
        }catch (IOException e){
            logger.error("Add group throws ex: "+e);
        }
    }

    @Override
    public void delete(int id) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))) {
            String currentLine;
            //Read all groups from file to LinkedList
            List<String> groups=new LinkedList<>();
            while((currentLine=bufferedReader.readLine())!=null){
                groups.add(currentLine);
                //Search group by ID in LinkedList
                StringBuilder sb=new StringBuilder();
                sb.append(GROUP_ID).append(String.valueOf(id)).append(GROUP_ID);
                for(int i=0;i<groups.size();i++){
                    if(groups.get(i).contains(sb)){
                        groups.remove(i);
                    }
                }
                //write changes in LinkedList to the file
                PrintWriter printWriter=new PrintWriter(new FileWriter("groups.txt",true));
                for(int i=0;i<groups.size();i++){
                    printWriter.println(sb);
                }
                printWriter.flush();
            }
        }catch (IOException e){
            logger.error("Delete group throws ex: "+e);
        }
    }

    @Override
    public void update(Group group) {
        if(get(group.getId()).getId()==group.getId()){
            delete(group.getId());
            add(group);
        }
    }

    @Override
    public Group get(int id) {
        Group group=new Group();

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("groups.txt"))){
            String currentLine;
            while ((currentLine=bufferedReader.readLine())!=null){
                if(getValue(GROUP_ID,currentLine).equals(String.valueOf(id))){
                    Subject subject=new Subject(getValue(SUBJECT_NAME,currentLine));
                    group.setSubject(subject);
                    String students_list=getValue(STUDETS_LIST,currentLine);
                    String[] student_id=getValues(STUDENT_ID,students_list);
                    List<Student> students=new ArrayList<>();
                    for (String studentID:student_id){
                        if(!studentID.isEmpty()){
                            int idS=Integer.valueOf(studentID);
                            StudentRepositoryFile studentRepositoryFile=new StudentRepositoryFile();
                            if(studentRepositoryFile.get(idS).getId()==idS){
                                students.add(studentRepositoryFile.get(idS));
                            }
                        }
                    }
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

    private String[] getValues(String value, String target) {
        String[] values = target.split(value);
        return values;
    }

}
