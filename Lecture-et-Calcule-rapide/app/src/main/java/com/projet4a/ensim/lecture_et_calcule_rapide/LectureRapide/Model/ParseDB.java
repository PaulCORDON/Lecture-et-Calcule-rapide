package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.Context.INPUT_SERVICE;

/**
 * Created by florentin on 01/02/18.
 */

public class ParseJSON extends Context {


    JSONObject object ;
    ArrayList<String> listMot = new ArrayList<String>();

    ParseJSON (String name ) throws IOException, JSONException {


        String content = AssetJSONFile(name,this );
        object = new JSONObject(content);


    }

    public static String AssetJSONFile (String filename, Context context) throws IOException {
        AssetManager manager;
        manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }


    public void execute (String letter) throws JSONException {
        JSONArray array ;
        String mot ;
        array = object.getJSONArray(letter);
        for (int i=0 ; i<array.length(); i++ ) {

            mot = (String) array.get(i);
            listMot.add(mot);





        }


    }







}
