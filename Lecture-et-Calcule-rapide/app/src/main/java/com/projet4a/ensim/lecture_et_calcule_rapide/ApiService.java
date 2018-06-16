package com.projet4a.ensim.lecture_et_calcule_rapide;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm2;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.model.Classe;

import java.util.ArrayList;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.Callback;


public interface ApiService {
    public static final String ENDPOINT = "http://172.24.1.1:9090";



    @GET("/classe")
    Call<ResponseBody> listClasses();


    @GET("/classe/{nom}/eleve/{nomPrenom}/paramEl1")
    ArrayList<ParamEl1> getParamEl1Eleve(@Path("nom") String nom,@Path("nomPrenom") String nomPrenom);

    @GET("/classe/{nom}/eleve/{nomPrenom}/paramEm1")
    ArrayList<ParamEm1> getParamEm1Eleve(@Path("nom") String nom,@Path("nomPrenom") String nomPrenom);

    @GET("/classe/{nom}/eleve/{nomPrenom}/paramEm2")
    ArrayList<ParamEm2> getParamEm2Eleve(@Path("nom") String nom, @Path("nomPrenom") String nomPrenom);

}
