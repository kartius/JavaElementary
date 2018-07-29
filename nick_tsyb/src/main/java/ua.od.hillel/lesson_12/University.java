package lesson_12;

public class University <T extends Student & Comparable>{


    private T student;

    public T getStudent() {
        return student;
    }

    public void setStudent(T student) {
        this.student = student;
    }
}
