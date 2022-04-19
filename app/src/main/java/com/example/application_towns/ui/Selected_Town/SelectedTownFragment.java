package com.example.application_towns.ui.Selected_Town;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.application_towns.R;
import com.example.application_towns.databinding.FragmentSelectedTownBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectedTownFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selected_town, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        TextView townView = view.findViewById(R.id.town_sel_t);
        TextView countryView = view.findViewById(R.id.country_sel_t);
        TextView languageView = view.findViewById(R.id.language_sel_t);
        TextView populationView = view.findViewById(R.id.population_sel_t);

        String town = "Town", country = "Country", language = "Language";
        int population = 0;

        String townArray = getArguments() == null ? "null" : getArguments().getString("town_array");
        try {
            JSONObject jsonObject = new JSONObject(townArray);
            population = jsonObject.getInt("Population");
            country = jsonObject.getString("Country");
            town = jsonObject.getString("Name");
            language = jsonObject.getString("language");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        populationView.setText(Integer.toString(population));
        countryView.setText(country);
        townView.setText(town);
        languageView.setText(language);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}