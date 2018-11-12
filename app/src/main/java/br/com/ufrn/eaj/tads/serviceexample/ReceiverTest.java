package br.com.ufrn.eaj.tads.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReceiverTest extends BroadcastReceiver {
    public ReceiverTest() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("Script", "onReceive()");
        context.startService(new Intent(context, ServicoTest.class));
    }

}
