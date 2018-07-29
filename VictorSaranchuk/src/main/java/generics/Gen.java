package generics;

public class Gen <T> {
T ob;
Gen(T o){
    ob=o;
}
T getob(){
    return ob;
}
void showType(){
    System.out.println("Type T is "+ob.getClass().getName());
}
}
