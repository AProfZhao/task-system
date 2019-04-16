package com.talenco.tasksystem.exception;

/**
 * 坏的参数异常
 * 应在方法接收到的参数不符合预期时抛出
 *
 * @author echcz
 * @date 2019-04-16 23:03:44
 */
public class BadParameterException extends RuntimeException {
    public BadParameterException() {
        super();
    }

    public BadParameterException(String s) {
        super(s);
    }

    public BadParameterException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BadParameterException(Throwable throwable) {
        super(throwable);
    }

    protected BadParameterException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
