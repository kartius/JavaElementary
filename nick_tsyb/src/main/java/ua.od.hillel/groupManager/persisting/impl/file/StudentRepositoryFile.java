package ua.od.hillel.groupManager.persisting.impl.file;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.config.ApplicationConfig;
import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.SchoolClass;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.StudentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryFile implements StudentRepository {

    final static Logger logger = Logger.getLogger(StudentRepositoryFile.class);
    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_NAME = "student_name";
    private static final String CLASS_LEVEL = "class_level";
    private static final String SUBJECTS_LIST = "subjects_list";
    private static final String SUBJECT_NAME = "subject_name";
    private static final String GROUP_ID = "group_id";
    private static final String GROUP_SUBJECT_NAME = "group_subject_name";
    private static final String GROUP_IS_AVAILABLE = "is_available";


    @Override
    public int getLevelClassOfStudent(Student student) {
        return 0;
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        return null;
    }

    @Override
    public void add(Student student) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt", true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(STUDENT_ID).append(student.getId()).append(STUDENT_ID)
                    .append(STUDENT_NAME).append(student.getName()).append(STUDENT_NAME)
                    .append(CLASS_LEVEL).append(student.getSchoolClass().getLevel()).append(CLASS_LEVEL).append(SUBJECTS_LIST);
            for (Subject subject : student.getSchoolClass().getSubjects()) {
                sb.append(SUBJECT_NAME).append(subject.getName()).append(SUBJECT_NAME);
            }
            sb.append(SUBJECTS_LIST);
            for (Group group : student.getGroups()) {
                sb.append(GROUP_ID).append(group.getId()).append(GROUP_ID)
                        .append(GROUP_SUBJECT_NAME).append(group.getSubject().getName()).append(GROUP_SUBJECT_NAME)
                        .append(GROUP_IS_AVAILABLE).append(group.isAvailable()).append(GROUP_IS_AVAILABLE);
            }
            sb.append("finishLine");
            bufferedWriter.write(sb + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            logger.error("Add student throws ex: ", e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student get(int id) {
        Student student = new Student();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (getVaue(STUDENT_ID, currentLine).equals(String.valueOf(id))) {
                    student.setId(id);
                    student.setName(getVaue(STUDENT_NAME, currentLine));
                    SchoolClass schoolClass = new SchoolClass();
                    schoolClass.setLevel(Integer.valueOf(getVaue(CLASS_LEVEL, currentLine)));
                    student.setSchoolClass(schoolClass);
                    String subjects_list = getVaue(SUBJECTS_LIST, currentLine);
                    String[] subject_names = getVaues(SUBJECT_NAME, subjects_list);
                    List<Subject> subjects = new ArrayList<>();
                    for (String subjectName : subject_names) {
                        if (!subjectName.isEmpty()) {
                            Subject subject = new Subject(subjectName);
                            subjects.add(subject);
                        }
                    }
                    student.getSchoolClass().setSubjects(subjects);
                    break;
                }
            }
        } catch (IOException e) {
            logger.error("Get student throws ex: ", e);
        }
        return student;
    }


    private String getVaue(String value, String target) {
        String result = null;
        String[] values = target.split(value);
        if (values.length == 3) {
            result = values[1];
        }
        return result;
    }

    private String[] getVaues(String value, String target) {
        String[] values = target.split(value);
        return values;
    }
}
