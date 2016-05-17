package com.zsx.xnhttplibrary;

/**
 * @author zheng.
 */
public interface XNHttpResponse<Req, Res> {
    Res getResponse();
    void setRequest(Req req);
}
