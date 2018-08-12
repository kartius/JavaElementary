package withcollection.Services;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentClassColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import withcollection.Persisting.StudentClassCollRepository;

public class StudentClassManager {

  private StudentClassCollRepository studentClassCollRepository;


  public void add(StudentClassColl studentClassColl) {studentClassCollRepository.add(studentClassColl);}
  public void del(StudentClassColl studentClassColl) {studentClassCollRepository.del(studentClassColl);}
  public void addStudentToClass (StudentClassColl stdClassColl, StudentColl std) {studentClassCollRepository.addStudentToClass(stdClassColl, std);}
  public void delStudentToClass (StudentClassColl stdClassColl, StudentColl std) {studentClassCollRepository.delStudentFromClass(stdClassColl, std);}
  public StudentClassColl getStudentClassColl(int index) {return studentClassCollRepository.getStudentClassColl(index);}

  public void setStudentClassCollRepository(StudentClassCollRepository studentClassCollRepository)
  {
      this.studentClassCollRepository = studentClassCollRepository;
  }
}
