package vn.nguyen.response;


import vn.nguyen.utils.ErrorCodes;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -2250278837442797730L;

    private String status = ErrorCodes.STATUS_OK.toString();
    private String messageCode;
    private String messageInfo;
    private T body;

    public BaseResponse() {

    }

    public BaseResponse(T body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
