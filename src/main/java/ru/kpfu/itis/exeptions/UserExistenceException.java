package ru.kpfu.itis.exeptions;

public class UserExistenceException extends Exception{
    public UserExistenceException() {
        super();
    }

    public UserExistenceException(String message) {
        super(message);
    }

    public UserExistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistenceException(Throwable cause) {
        super(cause);
    }

    protected UserExistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
