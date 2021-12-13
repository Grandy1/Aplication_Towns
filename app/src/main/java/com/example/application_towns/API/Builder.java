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

    public void init() {

        /*
        String baseurl = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/City.json";
        URL url = null;
        try {
            url = new URL(baseurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                StringBuilder response = new StringBuilder();
                BufferedReader input = new BufferedReader(new InputStreamReader
                        (conn.getInputStream()), 8192);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        //------------------------------------------------------------------------------

        String baseUrl = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TownsListAPI townsListApi = retrofit.create(TownsListAPI.class);

        Call<List<TownDescription>> townsList = townsListApi.townsList();

        townsList.enqueue(new Callback<List<TownDescription>>() {
            @Override
            public void onResponse(Call<List<TownDescription>> call, Response<List<TownDescription>> response) {
                List<TownDescription> townDescriptionList = response.body();
                TownDescription townDescription = townDescriptionList.get(0);

                Log.i("description", response.body().toString());
                Log.i("language", townDescription.getLanguage());
            }

            @Override
            public void onFailure(Call<List<TownDescription>> call, Throwable t) {
                Log.i("failure", t.toString());
            }
        });
    }

}
