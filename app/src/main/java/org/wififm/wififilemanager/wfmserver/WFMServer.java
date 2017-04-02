package org.wififm.wififilemanager.wfmserver;

import android.os.Debug;
import android.util.Log;

import org.wififm.wififilemanager.clients.ClientFactory;
import org.wififm.wififilemanager.models.AssetFileReader;
import org.wififm.wififilemanager.views.LoadingPage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by Admin on 01.04.2017.
 */

public class WFMServer extends NanoHTTPD {

    Map<String, String> headers, params;
    ClientFactory clientFactory;


    public WFMServer(int port, ClientFactory clientFactory) {
        super(port);
        this.clientFactory = clientFactory;
    }

    @Override
    public Response serve(IHTTPSession session) {

        //Debug.waitForDebugger();
        headers = session.getHeaders();
        String ip = headers.get("http-client-ip");
        String uri = session.getUri();

        if ( ip == null || uri == null )
        {
            if ( ip == null )
                return newFixedLengthResponse("Pleaseee, ippp");
            return newFixedLengthResponse("Please try again: uri");
        }

        if ( session.getMethod() == Method.GET )
        {
            if ( uri.indexOf("/wfm/web/") == 0 )
            {
                Log.i("GET ResourceFile", uri);
                String result = "";
                try {
                    return newFixedLengthResponse(AssetFileReader.readFile(uri.substring("/wfm/".length())));
                } catch (IOException e) {
                    e.printStackTrace();
                    return newFixedLengthResponse("");
                }
            }
            //if doesn't have permission, show error page

            if ( !clientFactory.clientExists(ip) )
            {
                if ( !clientFactory.addClient(ip) )
                    return newFixedLengthResponse("Please try again: cannot add you");
                return newFixedLengthResponse(LoadingPage.getHtml());
            }
            if ( !clientFactory.isFileReadable(ip, uri) )
            {
                return newFixedLengthResponse("");
            }

            if ( !clientFactory.isFileReadable(ip, uri) )
            {

            }
            File file = new File(uri);
            if ( !file.exists() )
            {
                //return 404 not found
            }

            if ( file.isDirectory() )
            {
                //send list of inner files
            }

            //show preview

        }

        if ( session.getMethod() == Method.POST )
        {
            if ( uri.equals(API.COPY) )
            {

            }
            else
            if ( uri.equals(API.CREATE_DIR) )
            {

            }
            else
            if ( uri.equals(API.DELETE) )
            {

            }
            else
            if ( uri.equals(API.DOWNLOAD) )
            {

            }
            else
            if ( uri.equals(API.MOVE) )
            {

            }
            else
            if ( uri.equals(API.UPLOAD) )
            {

            }
        }
        else
        {

        }
        return newFixedLengthResponse("sd");
    }
}
