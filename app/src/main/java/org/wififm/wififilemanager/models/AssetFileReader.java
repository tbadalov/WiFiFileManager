package org.wififm.wififilemanager.models;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Admin on 03.04.2017.
 */

public class AssetFileReader {

    private static AssetManager mgr;

    public static void setAssetManager(AssetManager am){
        mgr = am;
    }

    public static String readFile(String path) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(mgr.open(path), "UTF-8");
        try
        {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        }
        finally {
            in.close();
        }

        return out.toString();
    }
}
