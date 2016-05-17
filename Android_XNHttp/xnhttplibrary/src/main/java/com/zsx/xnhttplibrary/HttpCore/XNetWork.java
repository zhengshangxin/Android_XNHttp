package com.zsx.xnhttplibrary.HttpCore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zheng.
 */
public class XNetWork implements INetWork<INetRequest<?>, NetResponse> {

    @Override
    public NetResponse performRequest(INetRequest<?> iNetRequest) {

        NetResponse       netResponse   = null;
        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL(iNetRequest.getUrl());
            urlConnection = (HttpURLConnection) url.openConnection();
            // Set parameter.
            urlConnection.setConnectTimeout(iNetRequest.getConnectTimeout());
            urlConnection.setRequestMethod(iNetRequest.getRequestMethod());
            urlConnection.setChunkedStreamingMode(0);

            urlConnection.connect();

            // Output.
            OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
            outputStream.write(iNetRequest.getRequestBody());

            outputStream.flush();
            outputStream.close();

            // Input
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            ByteArray byteArray = new ByteArray();
            while (true) {
                byte[] buffer = new byte[1024];
                int cnt = inputStream.read(buffer);
                if (cnt > 0)
                    byteArray.append(buffer, cnt);
                else if (cnt == -1)
                    break;
            }

            netResponse = new NetResponse(byteArray.toByteArray());
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return netResponse;
    }
}
