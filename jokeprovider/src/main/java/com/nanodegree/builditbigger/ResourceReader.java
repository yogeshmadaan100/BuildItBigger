package com.nanodegree.builditbigger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yogeshmadaan on 21/02/16.
 */
public class ResourceReader {
    public static String getResource(String resourceName) throws IOException {
        InputStream inputStream = ResourceReader.class.getResourceAsStream("/" + resourceName);

        assert (inputStream != null);
        int n;
        byte[] buffer = new byte[81992];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((n = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, n);
        }

        return new String(bos.toByteArray());
    }
}
