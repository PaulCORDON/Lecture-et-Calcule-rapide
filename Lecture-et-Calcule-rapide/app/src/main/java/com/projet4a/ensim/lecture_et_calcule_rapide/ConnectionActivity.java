package com.projet4a.ensim.lecture_et_calcule_rapide;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.InformationActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.model.Classe;
import com.projet4a.ensim.lecture_et_calcule_rapide.model.Eleve;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ConnectionActivity extends AppCompatActivity {
    ArrayList<Classe> listeClasse = new ArrayList<Classe>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);



        Button buttonAnonyme= findViewById(R.id.connectAnonyme);
        Button buttonInfo = findViewById(R.id.InfoButton);
        Spinner listeClasses=findViewById(R.id.listeClasses);

        Spinner listeNoms=findViewById(R.id.listeNoms);

        ArrayList<String> arraySpinnerClasses=new ArrayList<String>();
        ArrayList<String> arraySpinnerNoms = new ArrayList<String>();


        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.spinner_item, arraySpinnerClasses){

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

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, arraySpinnerNoms){

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



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<ResponseBody> call = service.listClasses();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(
                    Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    String responseBody ="{classes:"+response.body().string()+"}";
                    Log.d("test",responseBody);
                    JSONObject Jobject = null;
                    try {
                        Jobject = new JSONObject(responseBody);
                        JSONArray Jarray = Jobject.getJSONArray("classes");
                        Log.d("size",Jarray.length()+"" );
                        Gson gson = new GsonBuilder().create();
                        String[] arrayClasses = new String[Jarray.length()];

                        for (int i = 0; i < Jarray.length(); i++) {
                            Classe c = gson.fromJson(Jarray.getJSONObject(i).toString(), Classe.class);
                            listeClasse.add(c);
                            Log.d("Liste des classe",listeClasse.get(i).getNom());
                            adapter1.insert(listeClasse.get(i).getNom(),i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });




        buttonAnonyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(ConnectionActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(ConnectionActivity.this, InformationActivity.class);
                startActivity(intent);

            }
        });
        listeClasses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              Log.d("OnChange classe",listeClasse.get(i).getListeEleve().size()+"");

                adapter2.clear();

                for (Eleve e:listeClasse.get(i).getListeEleve()) {
                    Log.d("nomPrenom",e.getNomPrenom());
                    adapter2.add(e.getNomPrenom());

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapter2.clear();
            }
        });

    }
}
