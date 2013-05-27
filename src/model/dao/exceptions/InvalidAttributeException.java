package model.dao.exceptions;

/**
 *
 * @author Alexander
 */
public class InvalidAttributeException extends Exception {

    public InvalidAttributeException(String msg) {
        super(msg);
    }
    
    public InvalidAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
