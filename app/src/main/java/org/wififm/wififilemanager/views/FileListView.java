package org.wififm.wififilemanager.views;

import java.util.List;

/**
 * Created by Admin on 02.04.2017.
 */

public class FileListView {
    List<String> files;

    public FileListView(List<String> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        String answer = "";
        for ( String file : files )
        {
            answer += file + "<br>";
        }

        return answer;
    }
}
