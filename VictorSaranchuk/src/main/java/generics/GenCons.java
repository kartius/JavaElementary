package generics;

public class GenCons {
    private  double val;
    <T extends Number>GenCons(T arg){
        val = arg.doubleValue();
    }
    void showval(){
        System.out.println(val);
    }
}
