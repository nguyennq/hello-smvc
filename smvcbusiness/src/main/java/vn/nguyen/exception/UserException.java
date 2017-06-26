package vn.nguyen.exception;

/**
 * Created by quocnguyen on 24/12/2015.
 */
public class UserException extends RuntimeException {
    private String errorCode;
    private String errorrMessage;

    public UserException(String errorrMessage, String errorCode) {
        this.errorrMessage = errorrMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorrMessage() {
        return errorrMessage;
    }

    public void setErrorrMessage(String errorrMessage) {
        this.errorrMessage = errorrMessage;
    }

}
