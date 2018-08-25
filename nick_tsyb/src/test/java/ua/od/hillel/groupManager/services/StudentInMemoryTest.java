package ua.od.hillel.groupManager.services;

import org.junit.*;
import org.junit.rules.ExpectedException;
import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.SchoolClass;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.StudentRepository;
import ua.od.hillel.groupManager.persisting.impl.memory.StudentRepositoryInMemory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StudentInMemoryTest {

    private StudentService studentService;
    private StudentRepository studentRepository;


    @Before
    public void setUp() {
        studentService = new StudentService();
        studentRepository = new StudentRepositoryInMemory();
        studentService.setStudentRepository(studentRepository);
    }


    @Test
    public void testAdd() {
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        studentService.add(student);

        assertEquals(1, studentService.getById(1).getId());
        assertEquals("test", studentService.getById(1).getName());
    }

    @Test
    public void testRemove() {
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        studentService.add(student);
        studentService.deleteById(1);
        assertNull(studentService.getById(1));
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        studentService.add(student);
        assertEquals(1, student.getId());
        assertEquals("test", student.getName());


        Student update = new Student();
        update.setId(1);
        update.setName("new");
        studentService.update(update);
        assertEquals(1, student.getId());
        assertEquals("new", student.getName());
    }

    @Test
    public void testListSubjects() {
        Student student = new Student();
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(1);
        schoolClass.setLevel(2);
        schoolClass.setSubjects(Arrays.asList(new Subject("math"), new Subject("history")));
        student.setId(1);
        student.setName("test");
        student.setSchoolClass(schoolClass);
        student.setGroups(new ArrayList<Group>());
        studentService.add(student);
        assertEquals(2, studentService.getAllSubjects(student).size());
    }

    @Test
    public void testClassLevel() throws Exception {
        Student student = new Student();
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(1);
        schoolClass.setLevel(5);
        schoolClass.setSubjects(Arrays.asList(new Subject("math"), new Subject("history")));
        student.setId(1);
        student.setName("test");
        student.setSchoolClass(schoolClass);
        student.setGroups(new ArrayList<Group>());
        studentService.add(student);
        assertEquals(5, studentService.getLevelClassOfStudent(student));
    }

    @Test(expected = Exception.class)
    public void testClassLevelWithUnexistedStudent() throws Exception {
        Student student = new Student();
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(1);
        schoolClass.setLevel(5);
        schoolClass.setSubjects(Arrays.asList(new Subject("math"), new Subject("history")));
        student.setId(1);
        student.setName("test");
        student.setSchoolClass(schoolClass);
        student.setGroups(new ArrayList<Group>());

        Student student1 = new Student();
        student1.setId(2);
        studentService.add(student);
        studentService.getLevelClassOfStudent(student1);
    }

}
