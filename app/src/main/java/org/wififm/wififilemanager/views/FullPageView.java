package org.wififm.wififilemanager.views;

import org.wififm.wififilemanager.models.HtmlHeaderModel;

import java.util.Arrays;

/**
 * Created by Admin on 02.04.2017.
 */

public class FullPageView {

    @Override
    public String toString() {

        return "<html>" + new HtmlHeaderModel() +
                "<body>" + new FileListView(Arrays.asList("hey", "heaaaa")) + "</body></html>";
    }
}
