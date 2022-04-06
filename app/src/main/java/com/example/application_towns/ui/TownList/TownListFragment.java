package com.example.application_towns.ui.TownList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application_towns.R;
import com.example.application_towns.adapter.TownListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TownListFragment extends Fragment {

    String[] towns_list = new String[21];
    String town;

    public static StringBuilder getResponse() {
        return response;
    }

    static StringBuilder response = new StringBuilder();

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            String url_text = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/City.json";
            URL url = null;
            try {
                url = new URL(url_text);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection conn = null;
            try {
                assert url != null;
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert conn != null;
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()), 8192);
                    String line;

                    while ((line = input.readLine()) != null) {
                        response.append(line);
                    }
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        thread.start();
        JSONObject jsonObject;
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                town = jsonObject.getString("Name");
                towns_list[i] = town;
            }
            int i;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.fragment_town_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        TownListAdapter townListAdapter = new TownListAdapter(towns_list);
        recyclerView.setAdapter(townListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}