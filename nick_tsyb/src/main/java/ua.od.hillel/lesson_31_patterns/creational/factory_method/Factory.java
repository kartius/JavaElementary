package ua.od.hillel.lesson_31_patterns.creational.factory_method;

public class Factory {

    public Storage create(String str) throws Exception {
        if (str.equals("DB")) {
            return new DBStorage();
        } else if (str.equals("FILE")) {
            return new FileStorage();
        }
        throw new Exception("");
    }
}
