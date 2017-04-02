package org.wififm.wififilemanager.gui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.wififm.wififilemanager.R;
import org.wififm.wififilemanager.clients.ClientFactory;
import org.wififm.wififilemanager.service.ServerService;

public class SecondActivity extends AppCompatActivity {

    private Button btnStart;
    private Intent intent;

    public static class MessageHandler extends Handler {
        private Context context;

        public MessageHandler(Context context) {
            this.context = context;
        }

        @Override
        public void handleMessage(Message message){
            String ip = null;
            if ( (ip = message.getData().getString(ClientFactory.NEW_CLIENT_REQUEST)) == null )
                return;
            Toast.makeText(context, "New Request: " + ip, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent = new Intent(this, ServerService.class);
        intent.putExtra("MESSENGER", new Messenger(new MessageHandler(this)));
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button", "is clicked");
                startService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }
}
