package com.zsx.xnhttplibrary;

import com.zsx.xnhttplibrary.HttpCore.NetResponse;

import java.util.Map;

/**
 * @author zheng.
 */
public class XNRequest<T> extends NetResponse {
    public XNRequest(int statusCode, byte[] datas, Map<String, String> headers, boolean notModified,
            long networkTimeMs) {
        super(statusCode, datas, headers, notModified, networkTimeMs);
    }

    public XNRequest(int statusCode, byte[] data, Map<String, String> headers,
            boolean notModified) {
        super(statusCode, data, headers, notModified);
    }

    public XNRequest(byte[] data) {
        super(data);
    }

    public XNRequest(byte[] data, Map<String, String> headers) {
        super(data, headers);
    }
}
