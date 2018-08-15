package solo.groupManager.model;
import java.util.List;

public class SchoolClass {
    private int level;
    private List<Subject> subjects;

    public int getLevel(){
        return level;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSubjects(List<Subject> subjects){
        this.subjects=subjects;
    }
}
