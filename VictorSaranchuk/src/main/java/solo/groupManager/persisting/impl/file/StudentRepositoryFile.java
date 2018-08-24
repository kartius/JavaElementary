package solo.groupManager.persisting.impl.file;

import solo.groupManager.model.Group;
import solo.groupManager.model.SchoolClass;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.StudentRepository;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class StudentRepositoryFile implements StudentRepository {
    final static Logger logger=Logger.getLogger(StudentRepositoryFile.class);
    private final static String STUDENT_ID="student_id";
    private final static String STUDENT_NAME="student_name";
    private final static String CLASS_LEVEL="class_level";
    private final static String SUBJECTS_LIST="subjects_list";
    private final static String SUBJECT_NAME="subject_name";
    private final static String GROUP_ID="group_id";
    private final static String GROUP_SUBJECT_NAME="group_subject_name";
    private final static String GROUP_IS_AVAILABLE="is_available";
    private final static String GROUPS_LIST="groups_list";
    private final static String GROUP_ONE="group_one";


    @Override
    public int getLevelClassOfStudent(Student student) {
        Student student1=get(student.getId());
        return student1.getSchoolClass().getLevel();
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        Student student1=get(student.getId());
        return student1.getSchoolClass().getSubjects();
    }

    @Override
    public void add(Student student) {
        try(PrintWriter printWriter=new PrintWriter(new FileWriter("students.txt", true))){
            StringBuilder sb=new StringBuilder();
            sb.append(STUDENT_ID).append(student.getId()).append(STUDENT_ID)
                    .append(STUDENT_NAME).append(student.getName()).append(STUDENT_NAME)
                    .append(CLASS_LEVEL).append(student.getSchoolClass().getLevel()).append(CLASS_LEVEL).append(SUBJECTS_LIST);
            for (Subject subject:student.getSchoolClass().getSubjects()){
                sb.append(SUBJECT_NAME).append(subject.getName()).append(SUBJECT_NAME);
            }
            sb.append(SUBJECTS_LIST).append(GROUPS_LIST);
            for(Group group:student.getGroups()){
                sb.append(GROUP_ONE).append(GROUP_ID).append(group.getId()).append(GROUP_ID)
                        .append(GROUP_SUBJECT_NAME).append(group.getSubject().getName()).append(GROUP_SUBJECT_NAME)
                        .append(GROUP_IS_AVAILABLE).append(group.isAvailable()).append(GROUP_IS_AVAILABLE).append(GROUP_ONE);
            }
            sb.append(GROUPS_LIST).append("finishLine");
            printWriter.println(sb);
            printWriter.flush();
        }catch (IOException e){
            logger.error("Add student throws ex: ", e);
        }
    }

    @Override
    public void delete(int id) {
        List<String> studentsString=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))){
            String currentLine;
            while((currentLine=bufferedReader.readLine())!=null){
                if(!(getValue(STUDENT_ID,currentLine).equals(String.valueOf(id)))){
                    studentsString.add(currentLine);
                }
            }
        }catch (IOException e){
            logger.error("Delete student throws ex: "+e);
        }
        try(PrintWriter printWriter=new PrintWriter(new FileWriter("students.txt"))){
            for (String student:studentsString
                 ) {
                printWriter.println(student);
            }
            printWriter.flush();
        }catch (IOException e){
            logger.error("Delete student throws ex: "+e);
        }
    }

    @Override
    public void update(Student student) {
        int id=student.getId();
        delete(id);
        add(student);
        List<Integer> students_id=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))){
            String currentLine;
            while((currentLine=bufferedReader.readLine())!=null){
                    students_id.add(Integer.valueOf(getValue(STUDENT_ID,currentLine)));
            }
            for (int student_id :students_id) {
                Student student1;
                student1=get(student_id);
                delete(student_id);
                add(student1);
            }

        }
        catch (IOException e){
            logger.error("Update student throws ex: "+e);
        }
    }

    @Override
    public Student get(int id) {
        Student student=new Student();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))){
            String currentLine;
            while((currentLine=bufferedReader.readLine())!=null){
                if(getValue(STUDENT_ID,currentLine).equals(String.valueOf(id))){
                    student.setId(id);
                    student.setName(getValue(STUDENT_NAME, currentLine));
                    SchoolClass schoolClass=new SchoolClass();
                    schoolClass.setLevel(Integer.valueOf(getValue(CLASS_LEVEL, currentLine)));
                    student.setSchoolClass(schoolClass);
                    String subjects_list=getValue(SUBJECTS_LIST,currentLine);
                    String[] subject_names=getValues(SUBJECT_NAME, subjects_list);
                    List<Subject> subjects=new ArrayList<>();
                    for(String subjectName:subject_names){
                        if(!subjectName.isEmpty()){
                            Subject subject=new Subject(subjectName);
                            subjects.add(subject);
                        }
                    }
                    student.getSchoolClass().setSubjects(subjects);
                    String groups_list=getValue(GROUPS_LIST, currentLine);
                    String[] groupsString=getValues(GROUP_ONE,groups_list);
                    List<Group> groups=new ArrayList<>();
                    for (String group:groupsString){
                        if(!group.isEmpty()){
                            Group group1=new Group();
                            group1.setId(Integer.valueOf(getValue(GROUP_ID,group)));
                            Subject subject=new Subject(GROUP_SUBJECT_NAME);
                            group1.setSubject(subject);
                            groups.add(group1);
                        }
                    }

                    break;
                }
            }
        }catch (IOException e){
            logger.error("Get student throws exx: "+e);
        }return student;
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
        String[] values=target.split(value);
    return values;
    }

}
