package com.example.application_towns.ui.TownList;

import android.os.Bundle;
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

public class TownListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_town_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        String[] data = getResources().getStringArray(R.array.towns);
        recyclerView.setAdapter(new TownListAdapter(data));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}