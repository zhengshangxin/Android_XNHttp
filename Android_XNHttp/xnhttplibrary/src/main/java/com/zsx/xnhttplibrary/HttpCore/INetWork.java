package com.zsx.xnhttplibrary.HttpCore;

/**
 * @author zheng.
 */
public interface INetWork<Req, Res> {

    Res performRequest(Req req);
}
