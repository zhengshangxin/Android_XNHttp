package com.zsx.xnhttplibrary.HttpCore;

import java.util.Collections;
import java.util.Map;

/**
 * @author zheng.
 */
public class NetResponse {

    /**
     * The HTTP status code.
     */
    public final int mStatusCode;

    /**
     * Raw data from this response.
     */
    public final byte[] mData;
    /**
     * Response headers.
     */
    public final Map<String, String> mHeaders;
    /**
     * True if the server returned a 304 (Not Modified).
     */
    public final boolean mNotModified;
    /**
     * Network roundtrip time in milliseconds.
     */
    public final long mNetworkTimeMs;

    public NetResponse(int statusCode, byte[] datas, Map<String, String> headers,
            boolean notModified, long networkTimeMs) {
        mStatusCode = statusCode;
        mData = datas;
        mHeaders = headers;
        mNotModified = notModified;
        mNetworkTimeMs = networkTimeMs;
    }

    public NetResponse(int statusCode, byte[] data, Map<String, String> headers,
            boolean notModified) {
        this(statusCode, data, headers, notModified, 0);
    }

    public NetResponse(byte[] data) {
        this(200, data, Collections.<String, String>emptyMap(), false, 0);
    }

    public NetResponse(byte[] data, Map<String, String> headers) {
        this(200, data, headers, false, 0);
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public byte[] getData() {
        return mData;
    }

    public boolean isNotModified() {
        return mNotModified;
    }

    public long getNetworkTimeMs() {
        return mNetworkTimeMs;
    }
}
