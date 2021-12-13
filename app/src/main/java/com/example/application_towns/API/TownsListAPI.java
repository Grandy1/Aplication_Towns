package com.example.application_towns.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TownsListAPI {

    @GET("City.json")
    Call<List<TownDescription>> townsList();
}
