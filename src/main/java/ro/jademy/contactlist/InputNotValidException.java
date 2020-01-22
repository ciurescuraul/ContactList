package ro.jademy.contactlist;

public class InputNotValidException extends Exception {

    private String fieldName;

    public InputNotValidException(String fieldName) {
        this.fieldName = fieldName;
    }

    public InputNotValidException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public InputNotValidException(String message, Throwable cause, String fieldName) {
        super(message, cause);
        this.fieldName = fieldName;
    }

    public InputNotValidException(Throwable cause, String fieldName) {
        super(cause);
        this.fieldName = fieldName;
    }

    public InputNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String fieldName) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
