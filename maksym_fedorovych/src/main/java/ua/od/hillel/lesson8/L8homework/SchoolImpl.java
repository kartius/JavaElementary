package main.java.ua.od.hillel.lesson8.L8homework;



public class SchoolImpl implements School {



    @Override
    public void CreateStudents(Student[] student) { /*Full student list*/
      for (int i = 0; i< student.length; i++) {
        student[i] = new Student();
        student[i].SName = "Студент " + i;
        student[i].unicid = i;
      }
    }

    @Override
    public void CreateStudentClass(StudentClass[] studentClass, int ClassLevel, int maxStudents) {/*Full studentclass list*/
       for (int i = 0; i< studentClass.length; i++) {
           studentClass[i] = new StudentClass();
           studentClass[i].ClassLevel = ClassLevel;
           studentClass[i].aMax = maxStudents;
       }
    }

    @Override
    public void CreateSubtectOfStudy(SubjectOfStudy[] subjectOfStudy) {
        for (int i = 0; i< subjectOfStudy.length; i++) {
            subjectOfStudy[i] = new SubjectOfStudy();
            subjectOfStudy[i].UnicId = i;
        }
    }


}
