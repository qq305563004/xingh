package com.tk.exception;

public class WebBusinessException extends RuntimeException {

    private static final long serialVersionUID = 2638941091792890333L;

    public WebBusinessException() {
        super();
    }

    public WebBusinessException(String retCode, Throwable cause) {
        super(retCode, cause);
    }

    public WebBusinessException(int retCode) {
        super(String.format("%05d", retCode));
    }

    public WebBusinessException(String retCode) {
        super(retCode);
    }

    public WebBusinessException(Throwable cause) {
        super(cause);
    }

}
