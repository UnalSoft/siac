package model.dao.exceptions;

/**
 *
 * @author Alexander
 */
public class DataBaseException extends Exception {

    public DataBaseException(String msg) {
        super(msg);
    }
    
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
