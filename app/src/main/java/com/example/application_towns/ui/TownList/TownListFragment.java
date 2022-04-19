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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

    private SwipeRefreshLayout swipeRefreshLayout;
    static StringBuilder response = new StringBuilder();

    public static StringBuilder getResponse() {
        return response;
    }

    Thread thread = new Thread(() -> {
        String url_text = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/City.json";
        URL url;
        try {
            url = new URL(url_text);
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
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
    });

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        thread.start();
        return inflater.inflate(R.layout.fragment_town_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        JSONObject jsonObject;
        String[] towns_list = null;
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            towns_list = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                towns_list[i] = jsonObject.getString("Name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        swipeRefreshLayout = getView().findViewById(R.id.SwipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(() -> swipeRefreshLayout.setRefreshing(false));
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new TownListAdapter(towns_list));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}