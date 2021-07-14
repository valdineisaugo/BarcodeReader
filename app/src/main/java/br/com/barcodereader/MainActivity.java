package br.com.barcodereader;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = findViewById(R.id.btnRead);
        //Ação do click
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Iniciar a cÂmera para leitura do código
                IntentIntegrator scan = new IntentIntegrator(MainActivity.this);
                scan.initiateScan();
            }
        });
    }
    //Processar o retorno da câmera
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent in){
        String contents = in.getStringExtra("SCAN_RESULT");
        String format = in.getStringExtra("SCAN_RESULT_FORMAT");
        Toast.makeText(this, contents, Toast.LENGTH_LONG).show();
    }
}