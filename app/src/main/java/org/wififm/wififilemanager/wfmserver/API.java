package org.wififm.wififilemanager.wfmserver;

/**
 * Created by Admin on 01.04.2017.
 */

public class API {
    private final static String name = "api";
    private final static String version = "v1";
    private final static String relative_uri = "/" + name + "/" + version + "/";

    public final static String DELETE = relative_uri + "delete";
    public final static String UPLOAD = relative_uri + "upload";
    public final static String CREATE_DIR = relative_uri + "create_dir";
    public final static String MOVE = relative_uri + "move";
    public final static String COPY = relative_uri + "copy";
    public final static String DOWNLOAD = relative_uri + "download";


}
