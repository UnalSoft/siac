package model.dao.exceptions;

/**
 *
 * @author Alexander
 */
public class InsufficientPermissionsException extends Exception {
    
    public InsufficientPermissionsException(String message, Throwable cause) {
        super(message, cause);
    }
    public InsufficientPermissionsException(String message) {
        super(message);
    }
    
}
