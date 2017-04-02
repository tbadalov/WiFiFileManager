package org.wififm.wififilemanager.clients;

/**
 * Created by Admin on 01.04.2017.
 */

public class Permission {

    public final static int READ = 1;
    public final static int WRITE = 2;
    public final static int SMS_READ = 4;
    public final static int SMS_WRITE = 8;
    public final static int CALLS_READ = 16;

    private int permission;

    public Permission(int permissionFlags) {
        this.permission = permissionFlags;
    }
}
