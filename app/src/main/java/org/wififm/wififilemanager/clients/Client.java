package org.wififm.wififilemanager.clients;

/**
 * Created by Admin on 01.04.2017.
 */

public class Client {

    private String ip;
    private Permission permissions;
    private String accessPath;



    public String getIP() {
        return ip;
    }

    public boolean isFileReadble(String path){
        return false; // must check whether client has access
    }

    public boolean isFileWritable(String path){
        return false;
    }

    public Client addPermission(int permission){
        return  this;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }
}
