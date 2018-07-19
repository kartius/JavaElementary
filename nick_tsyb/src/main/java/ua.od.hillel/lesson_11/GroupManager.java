package lesson_11;

import java.util.ArrayList;
import java.util.List;

public class GroupManager {


    private List students = new ArrayList();

    public void addStudent(String studentName) throws GroupSizeLimitException {
        if (students.size() == 0) {
            throw new GroupSizeLimitException("Size of group equals 6");

        }


    }


}
