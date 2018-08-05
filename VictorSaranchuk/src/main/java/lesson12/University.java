package lesson12;

public class University<T extends Student > {

    private T student;

    public T getStudent() {
        return student;
    }

    public void setStudent(T student) {
        this.student = student;
    }
}
