package lesson_12;

import java.io.Serializable;


public class Student implements Comparable{




    public void sort(){

        new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

    }



    public void doHomeWork(){
        System.out.println("I'm doing homework");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
