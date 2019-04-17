package com.talenco.tasksystem.exception;

/**
 * 客户端异常
 * 当因客户端的原因产生异常时应抛出此异常或将已抛出的异常用此类包装后再抛出
 *
 * @author echcz
 * @date 2019-04-17 21:58:11
 */
public class ClientException extends RuntimeException {
    /**
     * 在抛出此异常时预期返回给客户端的http状态码
     * 默认为400
     */
    private int httpStatus = 400;

    public ClientException() {
    }

    public ClientException(int httpStatus) {
        setHttpStatus(httpStatus);
    }

    public ClientException(String s) {
        super(s);
    }

    public ClientException(int httpStatus, String s) {
        this(s);
        setHttpStatus(httpStatus);
    }

    public ClientException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ClientException(int httpStatus, String s, Throwable throwable) {
        this(s, throwable);
        setHttpStatus(httpStatus);
    }

    public ClientException(Throwable throwable) {
        super(throwable);
    }

    public ClientException(int httpStatus, Throwable throwable) {
        this(throwable);
        setHttpStatus(httpStatus);
    }

    public ClientException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

    public ClientException(int httpStatus, String s, Throwable throwable, boolean b, boolean b1) {
        this(s, throwable, b, b1);
        setHttpStatus(httpStatus);
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
