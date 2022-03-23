package com.example.application_towns.API;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Builder {

    public void init(Callback<List<TownDescription>> callback) {

        TownDescriptionList townDescList = new TownDescriptionList();
        String baseUrl = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TownsListAPI townsListApi = retrofit.create(TownsListAPI.class);

        Call<List<TownDescription>> townsList = townsListApi.townsList();

        townsList.enqueue(callback);
    }
}
