package br.com.ufrn.eaj.tads.serviceexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Solicita as permissões
        String[] permissoes = new String[]{
                Manifest.permission.READ_SMS,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.RECEIVE_SMS
        };
        PermissionUtils.validate(this, 0, permissoes);
    }
    public void startService(View view){
        startService(new Intent(this, ServicoTest.class));
    }

    public void stopService(View view){
        stopService(new Intent(this, ServicoTest.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                // Alguma permissão foi negada, agora é com você :-)
                finish();
                return;
            }
        }
        // Se chegou aqui está OK :-)
    }
}
