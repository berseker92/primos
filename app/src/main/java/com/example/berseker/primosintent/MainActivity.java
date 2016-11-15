package com.example.berseker.primosintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText recibe,atrapa;
    private Button btn,clear;
    public int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    recibe=(EditText)findViewById(R.id.recibe);
    atrapa=(EditText)findViewById(R.id.atrapa);
    btn=(Button)findViewById(R.id.btn);
    clear=(Button)findViewById(R.id.clear);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           String vec =recibe.getText().toString();
            numero=Integer.parseInt(vec);

            Intent dato = new Intent(MainActivity.this,Myintento.class);
            dato.putExtra("valor",numero);
            startService(dato);

        }
    });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recibe.setText("");
                atrapa.setText("");
            }
        });




        IntentFilter filter = new IntentFilter();
        filter.addAction(Myintento.ACTION_UNO);
        ProgresReceiver rcv = new ProgresReceiver();
        registerReceiver(rcv,filter);





    }


    public class ProgresReceiver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Myintento.ACTION_UNO)){

                int prog =intent.getIntExtra("envio",0);
                atrapa.setText(prog+"\n"+atrapa.getText().toString());

            }
        }
    }

}
