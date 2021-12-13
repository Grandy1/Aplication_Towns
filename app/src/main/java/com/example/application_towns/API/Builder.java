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

        String baseUrl = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TownsListAPI townsListApi = retrofit.create(TownsListAPI.class);

        Call<List<TownDescription>> townsList = townsListApi.townsList();

        townsList.enqueue(new Callback<List<TownDescription>>() {
            @Override
            public void onResponse(Call<List<TownDescription>> call,
                                   Response<List<TownDescription>> response) {
                if (response.isSuccessful()) {
                    List<TownDescription> townDescriptionList = response.body();
                    int i = 0;
                    for (TownDescription townDescription : townDescriptionList) {
                        Log.i("id " + i++, "Population: " + townDescription.getPopulation() +
                                "; Country: " + townDescription.getCountry() +
                                "; Name: " + townDescription.getName() +
                                "; language: " + townDescription.getLanguage() + ";");
                    }
                } else {
                    Log.i("Response code", "" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<TownDescription>> call, Throwable t) {
                Log.i("failure", t.toString());
            }
        });
    }

}
