package lesson_12;


public class Runner {


    public static void main(String[] args) {


//        Box box1 = new Box();
//        box1.setItem(new Integer(12));
//
//
//        if (box1.getClass().equals(Integer.class)) {
//
//            System.out.println(box1.getItem());
//        }
//
//
//        Box box2 = new Box();
//        box2.setItem("213");
//        System.out.println(box2.getItem());


//        BoxG<Integer> boxG1 = new BoxG<>();
//        boxG1.setItem(12);
//
//        boxG1.getItem();
//
//
//        BoxG<String> boxG2 = new BoxG<>();



//
//        Box value1 = new Box();
//        value1.setItem(new Integer(12));
//
//        Integer intValue1 = (Integer) value1.getItem();
//        System.out.println(intValue1);
//
//
//        Box value2 = new Box();
//        value2.setItem('a');
//        Integer intValue2 = (Integer) value2.getItem();
//        System.out.println(intValue2);




        University<Student, Object> university1 = new University<>();
        university1.setStudent(new Student());
        university1.getStudent().doHomeWork();














    }


}
