package com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;




public class GenerateQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        /*
        Récupération des notes de l'élève
         */
        final Intent intent = getIntent();
        final String exo = intent.getStringExtra("exo");
        final Integer bonneRep =intent.getIntExtra("bonneRep",0);
        final Integer nbRep = intent.getIntExtra("nbRep",0);
        /*
        lien avec la vue
         */
        final ImageView qrCode = (ImageView) findViewById(R.id.QRCode);
        final Button retourMenu=(Button) findViewById(R.id.BtnMenu);
        final Button generer=(Button)findViewById(R.id.BtnGenerer);
        final EditText nom=(EditText) findViewById(R.id.Nom);
        final EditText prenom=(EditText) findViewById(R.id.Prenom);


        generer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=prenom.getText()+" "+nom.getText()+" "+exo+" "+bonneRep+" "+nbRep;
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix=multiFormatWriter.encode(message, BarcodeFormat.QR_CODE,500,500);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    qrCode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });




        /*
        Si on clic sur le bouton "retour vers le menu" on retourne au menu
         */
        retourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenerateQRCodeActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });




    }
}
