package com.talenco.tasksystem.exception;

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
