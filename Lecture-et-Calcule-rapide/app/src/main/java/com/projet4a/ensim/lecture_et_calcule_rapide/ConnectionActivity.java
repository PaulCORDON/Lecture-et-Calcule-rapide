package com.projet4a.ensim.lecture_et_calcule_rapide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        Button buttonAnonyme= findViewById(R.id.connectAnonyme);
        Spinner listeClasses=findViewById(R.id.listeClasses);

        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        listeClasses.setAdapter(adapter);


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
