package com.projet4a.ensim.lecture_et_calcule_rapide.ApiService;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm2;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.model.Classe;

public enum Service {
    INSTANCE;

    private static final String TAG = "Service";

    public void getClasses(Response.Listener respListener,Response.ErrorListener errorListener,Context context){
        final String url="https://172.24.1.1:9090/classe";
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<Classe[]> request =
                new GsonRequest<>(url,Classe[].class,null,respListener,errorListener);
        queue.add(request);
    }

    public void getEleveParamEm1(String nomClasse, String nomprenom, Response.Listener respListener,Response.ErrorListener errorListener,Context context){
        final String url="http://172.24.1.1:9090/classe/"+nomClasse+"/eleve/"+nomprenom+"/paramEm1";
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<ParamEm1> requestEm1 =
                new GsonRequest<>(url,ParamEm1.class,null,respListener,errorListener);

        queue.add(requestEm1);
    }

    public void getEleveParamEm2(String nomClasse, String nomprenom, Response.Listener respListener,Response.ErrorListener errorListener,Context context){
        final String url="http://172.24.1.1:9090/classe/"+nomClasse+"/eleve/"+nomprenom+"/paramEm2";
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<ParamEm2> requestEm2 =
                new GsonRequest<>(url,ParamEm2.class,null,respListener,errorListener);

        queue.add(requestEm2);
    }

    public void getEleveParamEl1(String nomClasse, String nomprenom, Response.Listener respListener,Response.ErrorListener errorListener,Context context){
        final String url="http://172.24.1.1:9090/classe/"+nomClasse+"/eleve/"+nomprenom+"/paramEl1";
        Log.d(TAG,url);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<ParamEl1> requestEl1 =
                new GsonRequest<>(url,ParamEl1.class,null,respListener,errorListener);

        queue.add(requestEl1);
    }
}