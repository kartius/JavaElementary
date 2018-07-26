package ua.od.hillel.vadim_zadorozhnyuk.taskArrays;

public class InputExceptions extends Exception {
    public InputExceptions() {
    }

    public InputExceptions(String message) {
        super(message);
    }

    public InputExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public InputExceptions(Throwable cause) {
        super(cause);
    }

    public InputExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
