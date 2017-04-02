package org.wififm.wififilemanager.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import org.wififm.wififilemanager.clients.ClientFactory;
import org.wififm.wififilemanager.interfaces.IGUIClientRequestor;
import org.wififm.wififilemanager.models.AssetFileReader;
import org.wififm.wififilemanager.wfmserver.WFMServer;

import java.io.IOException;

/**
 * Created by Admin on 01.04.2017.
 */

public class ServerService extends Service implements IGUIClientRequestor{

    private ClientFactory clientFactory;
    private Messenger messageHandler;
    private WFMServer server;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Instance of server", "Is created");
        AssetFileReader.setAssetManager(getAssets());
        clientFactory = new ClientFactory(this);
        server = new WFMServer(1234, clientFactory);
        Log.i("Instance of server", "Is created");
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Server", "Is running");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        messageHandler = (Messenger) intent.getExtras().get("MESSENGER");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean requestNewClient(String ip) {
        if ( ip == null )
            return false;
        Log.i("Requesting Client:" + ip, "Started");
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString(ClientFactory.NEW_CLIENT_REQUEST, ip);
        msg.setData(bundle);
        Log.i("Sending request", "Started");
        try {
            messageHandler.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        if ( server.isAlive() )
            server.stop();
        super.onDestroy();
    }
}
