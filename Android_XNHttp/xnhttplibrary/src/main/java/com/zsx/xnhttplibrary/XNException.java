package com.zsx.xnhttplibrary;

/**
 * @author zheng.
 */
public class XNException extends Exception {

    public XNException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public XNException(String detailMessage) {
        super(detailMessage);
    }

    public XNException(Throwable throwable) {
        super(throwable);
    }

    public XNException() {}
}
