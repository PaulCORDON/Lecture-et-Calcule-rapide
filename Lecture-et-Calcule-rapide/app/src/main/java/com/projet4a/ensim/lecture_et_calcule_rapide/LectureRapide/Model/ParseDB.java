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
import java.util.Scanner;

import static android.content.Context.INPUT_SERVICE;

/**
 * Created by florentin on 01/02/18.
 *
 * Cette classe recupère tous les mots contenu dans un fichier txt et les mets dans une ArrayList
 */

public class ParseDB  {


    File database;
    ArrayList <String> listMot ;

    ParseDB (String path){

        database = new File (path);
        listMot = new ArrayList<>();


    }



    public void execute () {
        try (Scanner sc = new Scanner("database")) {
            String mot = "a";
            do {

                mot = sc.nextLine();
                listMot.add(mot);


            } while (!mot.equals("-1"));
        }




    }


    }







