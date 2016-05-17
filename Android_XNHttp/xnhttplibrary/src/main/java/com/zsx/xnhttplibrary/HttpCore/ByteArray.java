package com.zsx.xnhttplibrary.HttpCore;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * @author zheng.
 */
public class ByteArray {

    private final ArrayList<byte[]>  mItems  = new ArrayList<>();
    private final ArrayList<Integer> mCounts = new ArrayList<>();
    private       int                mLength = 0;

    public ByteArray append(String item) throws IllegalArgumentException {
        append(item.getBytes());
        return this;
    }

    public ByteArray append(byte[] item) throws IllegalArgumentException {
        append(item, item.length);
        return this;
    }

    public ByteArray append(byte[] item, int byteCount) throws IllegalArgumentException {
        if (byteCount < 1 || byteCount > item.length) throw new IllegalArgumentException();

        mItems.add(item);
        mCounts.add(byteCount);
        mLength += byteCount;
        return this;
    }

    public byte[] toByteArray() {
        byte[] ret = new byte[mLength];
        for (int i = 0, n = 0; i < mItems.size(); i++) {
            byte[] item  = mItems.get(i);
            int    count = mCounts.get(i);

            System.arraycopy(item, 0, ret, n, count);
            n += count;
        }
        return ret;
    }

    @Override
    public String toString() {
        try {
            return new String(toByteArray(), 0, mLength, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
    }
}
