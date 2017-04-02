package org.wififm.wififilemanager.views;

import org.wififm.wififilemanager.models.AssetFileReader;

import java.io.IOException;

/**
 * Created by Admin on 02.04.2017.
 */

public class LoadingPage {

    public static String getHtml() {

        String result = "Something went wrong";
        try {
            result = AssetFileReader.readFile("web/loading.html");
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }

        return result;
    }

}
