package lesson11HomeWork;

public class ScannerException extends Exception {
    private String mess;
    public String getMess(){return  mess;}
    public ScannerException(String message, String mess){
        super(message);
        this.mess=mess;
    }

}
