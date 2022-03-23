package com.example.application_towns.ui.TownList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application_towns.API.Builder;
import com.example.application_towns.API.TownDescription;
import com.example.application_towns.API.TownDescriptionList;
import com.example.application_towns.R;
import com.example.application_towns.adapter.TownListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TownListFragment extends Fragment {

    TownDescriptionList townDescList = new TownDescriptionList();
    private List<String> recyclerData = new ArrayList<>();
    private TownListAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_town_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //recyclerData = townDescList.getStringArray();
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        String[] data = getResources().getStringArray(R.array.towns);
        recyclerData = Arrays.asList(data);
        //mAdapter = new TownListAdapter(recyclerData);
        //recyclerView.setAdapter(mAdapter);
        Builder builder = new Builder();
        builder.init(new Callback<List<TownDescription>>() {
            @Override
            public void onResponse(Call<List<TownDescription>> call,
                                   Response<List<TownDescription>> response) {
                if (response.isSuccessful()) {
                    List<TownDescription> townDescriptionList = response.body();
                    int i = 0;
                    for (TownDescription townDescription : townDescriptionList) {
                        townDescList.setString(townDescription.getCountry());
                        Log.i("id " + i++, "Population: " + townDescription.getPopulation() +
                                "; Country: " + townDescription.getCountry() +
                                "; Name: " + townDescription.getName() +
                                "; language: " + townDescription.getLanguage() + ";");
                    }
                    /*recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new TownListAdapter(townDescList.getStringArray());
                            recyclerView.setAdapter(mAdapter);
                        }
                    });*/
                } else {
                    Log.i("Response code", "" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<TownDescription>> call, Throwable t) {
                Log.i("failure", t.toString());
            }
        });
        mAdapter = new TownListAdapter(recyclerData);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}