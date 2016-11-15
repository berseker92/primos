package com.example.berseker.primosintent;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by berseker on 11/14/2016.
 */

public class Myintento extends IntentService {
public static final String ACTION_UNO="com.example.intent.action.uno";

    public Myintento() {super("Myintento");}




    @Override
    protected void onHandleIntent(Intent intent) {
     int m;
     boolean temp;
    int  ter= intent.getIntExtra("valor",0);
   for(int x=2;x<ter;x++) {
       Intent trans = new Intent();
       m = 2;
       temp = true;
       while (temp && m < x) {
           if (x % m == 0)
               temp = false;
           else
               m = m + 1;
       }
       if (temp)
           trans.setAction(ACTION_UNO);
           trans.putExtra("envio",x);
          sendBroadcast(trans);
   }




    }
}
