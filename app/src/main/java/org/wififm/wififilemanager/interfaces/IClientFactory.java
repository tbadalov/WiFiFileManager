package org.wififm.wififilemanager.interfaces;

/**
 * Created by Admin on 01.04.2017.
 */

public interface IClientFactory {

    boolean isFileReadable(String ip, String path);
    boolean isFileWriteable(String ip, String path);
    boolean clientExists(String ip);
    boolean addClient(String ip);

}
