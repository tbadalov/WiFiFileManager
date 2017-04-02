package org.wififm.wififilemanager.clients;

import android.util.Log;

import org.wififm.wififilemanager.interfaces.IClientFactory;
import org.wififm.wififilemanager.interfaces.IGUIClientRequestor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 01.04.2017.
 */

public class ClientFactory implements IClientFactory {
    public final static String NEW_CLIENT_REQUEST = "NEW_CLIENT_REQUEST";
    private Map<String, Client> clients;
    IGUIClientRequestor requestor;

    public ClientFactory(IGUIClientRequestor requestor) {
        this.requestor = requestor;
        clients = new HashMap<>();
    }

    @Override
    public boolean isFileReadable(String ip, String path) {
        Client c = null;
        return clientExists(ip, c) && c.isFileReadble(path);
    }

    private boolean clientExists(String ip, Client c){
        return (c = clients.get(ip)) != null;
    }

    @Override
    public boolean isFileWriteable(String ip, String path) {
        return false;
    }

    @Override
    public boolean clientExists(String ip) {
        return clients.get(ip) != null;
    }

    @Override
    public boolean addClient(String ip) {
        if ( clientExists(ip) )
            return true;
        Log.i("Existense of client" + ip, "false");
        Log.i("New client", "Requested successfully");
        return requestor.requestNewClient(ip);
    }
}
