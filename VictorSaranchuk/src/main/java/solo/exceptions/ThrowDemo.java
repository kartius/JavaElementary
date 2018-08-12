package solo.exceptions;

public class ThrowDemo {
    static void demoproc(){
        try{
            throw new NullPointerException("demonstration");
        } catch (NullPointerException e){
            System.out.println("Exception was intercept in method demoproc().");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Twice intercept: "+e);
        }
    }
}
