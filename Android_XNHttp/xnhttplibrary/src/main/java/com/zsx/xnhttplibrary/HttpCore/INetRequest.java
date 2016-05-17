package com.zsx.xnhttplibrary.HttpCore;

/**
 * @author zheng.
 */
public interface INetRequest<T> {

    byte[] getRequestBody();

    String getUrl();

    int getConnectTimeout();

    String getRequestMethod();
}
