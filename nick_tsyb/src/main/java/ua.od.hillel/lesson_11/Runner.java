package lesson_11;

import java.io.*;

public class Runner {


    public static void main(String[] args) {

//        try {
//            Calculator calculator = new Calculator();
//            int div = calculator.div(1, 0);
//            System.out.println(div);
//        } catch (RuntimeException e) {
//            System.out.println("division by zero");
//
//        }


//        Reader reader = new Reader();
//
//
//        if (reader.read("fff")) {
//            System.out.println("open file");
//        } else {
//            System.out.println("");
//        }
//
//

//        Reader reader = new Reader();
//        reader.read("bla");


//        GroupManager groupManager = new GroupManager();
//        try {
//            groupManager.addStudent("sss");
//        } catch (GroupSizeLimitException e) {
//            e.printStackTrace();
//        }


        FileInputStream fileInputStream = null;

//        try {
//            fileInputStream = new FileInputStream(new File("123"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }else{
//                    System.out.println("File wasn't created");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


//        try(FileInputStream fileInputStream1 = new FileInputStream(new File("123"))){
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        try(Resource resource = new Resource()) {
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
