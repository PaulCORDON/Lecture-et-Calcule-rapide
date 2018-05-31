package com.projet4a.ensim.lecture_et_calcule_rapide;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        Button buttonAnonyme= findViewById(R.id.connectAnonyme);
        Spinner listeClasses=findViewById(R.id.listeClasses);

        Spinner listeNoms=findViewById(R.id.listeNoms);

        String[] arraySpinnerClasses = new String[] {
                "1", "2", "3", "4", "5"
        };

        String[] arraySpinnerNoms = new String[] {
                "nom1", "nom2", "nom3", "nom4", "nom5"
        };


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

    }
}
