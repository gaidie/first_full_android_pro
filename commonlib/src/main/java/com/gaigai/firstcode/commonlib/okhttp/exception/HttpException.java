package com.gaigai.firstcode.commonlib.okhttp.exception;

/**
 * Created by ga on 2017/2/16.
 */

public class HttpException extends Exception {

    private int errorCode;
    private Object errorMsg;

    public HttpException(int errorCode, Object errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }
}
