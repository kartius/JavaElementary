package solo.groupManager.persisting.impl.file;

import solo.groupManager.model.Group;
import solo.groupManager.model.SchoolClass;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.GroupRepository;
import solo.groupManager.persisting.StudentRepository;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
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


    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
//        int levelClassOfStudent=0;
//        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))) {
//            String currentLine;
//            //Read all students from file to LinkedList
//            List<String> students = new LinkedList<>();
//            while ((currentLine = bufferedReader.readLine()) != null) {
//                students.add(currentLine);
//            }
//            //Search student by ID in LinkedList
//            StringBuilder sb = new StringBuilder();
//            sb.append(STUDENT_ID).append(student.getId()).append(STUDENT_ID);
//            for(int i=0; i<students.size();i++){
//                if(students.get(i).contains(sb)){
//                    String[] st=students.get(i).split(CLASS_LEVEL);
//                    if(st.length==3){
//                    levelClassOfStudent=Integer.valueOf(st[1]);
//                    }
//                }
//            }
//        }
//        return levelClassOfStudent;
        if(get(student.getId()).getId()==student.getId()){
            return get(student.getId()).getSchoolClass().getLevel();
        }
        else return 0;
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        List<Subject> allSubjects = new ArrayList<Subject>();
        allSubjects.addAll(get(student.getId()).getSchoolClass().getSubjects());
        for(Group group:get(student.getId()).getGroups()){
            if(group.isAvailable()){
                allSubjects.add(group.getSubject());
            }
        }
        return allSubjects;
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
            sb.append(SUBJECTS_LIST);
            for(Group group:student.getGroups()){
                sb.append(GROUP_ID).append(group.getId()).append(GROUP_ID)
                        .append(GROUP_SUBJECT_NAME).append(group.getSubject().getName()).append(GROUP_SUBJECT_NAME)
                        .append(GROUP_IS_AVAILABLE).append(group.isAvailable()).append(GROUP_IS_AVAILABLE);
            }
            sb.append("finishLine");
            printWriter.println(sb);
            printWriter.flush();
        }catch (IOException e){
            logger.error("Add student throws ex: ", e);
        }
    }

    @Override
    public void delete(int id) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))){
            String currentLine;
            //Read all students from file to LinkedList
            List<String> students=new LinkedList<>();
            while((currentLine=bufferedReader.readLine())!=null){
                students.add(currentLine);
            }
            //Search student by ID in LinkedList
            StringBuilder sb=new StringBuilder();
            sb.append(STUDENT_ID).append(String.valueOf(id)).append(STUDENT_ID);
            for(int i=0;i<students.size();i++){
                if(students.get(i).contains(sb)){
                    students.remove(i);
                }
            }
            //write changes in LinkedList to the file
            PrintWriter pr=new PrintWriter(new FileWriter("students.txt"),true);
            for(int i=0;i<students.size();i++){
                pr.println(students.get(i));
            }
            pr.flush();
        } catch (IOException e) {
            logger.error("Delete student throws ex "+e);
        }
    }

    @Override
    public void update(Student student) {
        if(get(student.getId()).getId()==student.getId()) {
        delete(student.getId());
        add(student);
        }
    }

    @Override
    public Student get(int id) {
        Student student=new Student();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("students.txt"))){
            String currentLine;
            while((currentLine=bufferedReader.readLine())!=null){
                if(getValue(STUDENT_ID,currentLine).equals(String.valueOf(id))){
                    student.setName(getValue(STUDENT_NAME, currentLine));
                    SchoolClass schoolClass=new SchoolClass();
                    schoolClass.setLevel(Integer.valueOf(getValue(CLASS_LEVEL, currentLine)));
                    student.setSchoolClass(schoolClass);
                    String subjets_list=getValue(SUBJECTS_LIST,currentLine);
                    String[] subject_names=getValues(SUBJECT_NAME, subjets_list);
                    List<Subject> subjects=new ArrayList<>();
                    for(String subjectName:subject_names){
                        if(!subjectName.isEmpty()){
                            Subject subject=new Subject(subjectName);
                            subjects.add(subject);
                        }
                    }
                    student.getSchoolClass().setSubjects(subjects);
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
        String[] values = target.split(value);
        return values;
    }
}
