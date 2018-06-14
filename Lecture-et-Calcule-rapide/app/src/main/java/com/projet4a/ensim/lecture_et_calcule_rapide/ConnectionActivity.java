package com.projet4a.ensim.lecture_et_calcule_rapide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.projet4a.ensim.lecture_et_calcule_rapide.ApiService.Service;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.InformationActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.model.Classe;

import java.util.List;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if(initWifi(this)){

            Classe[] listeClasse;

            setContentView(R.layout.activity_connection);

            Button buttonAnonyme= findViewById(R.id.connectAnonyme);
            Spinner listeClasses=findViewById(R.id.listeClasses);

            Spinner listeNoms=findViewById(R.id.listeNoms);

            String[] arraySpinnerClasses = new String[] {
                    "Classe","1", "2", "3", "4", "5"
            };

            String[] arraySpinnerNoms = new String[] {
                    "nom1", "nom2", "nom3", "nom4", "nom5"
            };

            Response.Listener<Classe[]> responseListener = new Response.Listener<Classe[]>() {
                @Override
                public void onResponse(Classe[] response) {
                    Log.w("test",response.toString());
                }
            };
            Response.ErrorListener errorListener=new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.w("erreur",error);
                }
            };
            Service.INSTANCE.getClasses(responseListener,errorListener,this);

            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                    R.layout.spinner_item, arraySpinnerClasses){

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;

                    tv.setBackgroundColor(Color.parseColor("#3b3b36"));

                    return view;
                }
            };
            adapter1.setDropDownViewResource(R.layout.spinner_item);
            listeClasses.setAdapter(adapter1);

            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinner_item, arraySpinnerNoms){

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;

                    tv.setBackgroundColor(Color.parseColor("#3b3b36"));

                    return view;
                }
            };
            adapter2.setDropDownViewResource(R.layout.spinner_item);
            listeNoms.setAdapter(adapter2);


            buttonAnonyme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent;
                    intent = new Intent(ConnectionActivity.this, MenuActivity.class);
                    startActivity(intent);

                }
            });

            Button buttonEleve = findViewById(R.id.button3);

            buttonEleve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    intent = new Intent(ConnectionActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

//        }
//        else {
//            Intent intent = new Intent(ConnectionActivity.this, MenuActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }

//    boolean initWifi(Context context){
//        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
//
//        wifiManager.startScan();
//
//        List<ScanResult> scanResults = wifiManager.getScanResults();
//
//        Log.w("Connexion : ","scanResults : " + scanResults);
//
//        String networkSSID = "\"LectureEtCalculRapide\"";
//
//        Log.w("Connexion : ","SSID : " + networkSSID);
//
//        for(ScanResult sr: scanResults){
//            Log.w("Connexion : ","SSID result : " + sr.SSID);
//            if(sr.SSID == networkSSID){
//                WifiConfiguration conf = new WifiConfiguration();
//                conf.SSID = networkSSID;
//
//                conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//
//                wifiManager.addNetwork(conf);
//
//                List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
//                for( WifiConfiguration i : list ) {
//                    if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
//                        wifiManager.disconnect();
//                        wifiManager.enableNetwork(i.networkId, true);
//                        wifiManager.reconnect();
//
//                        Log.w("Connexion : ","success");
//                        return true;
//                    }
//                }
//            }
//        }
//        Log.w("Connexion : ","fail");
//        return false;
//    }
}
