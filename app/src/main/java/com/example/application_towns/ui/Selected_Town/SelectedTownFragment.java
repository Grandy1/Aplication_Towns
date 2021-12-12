package com.example.application_towns.ui.Selected_Town;

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

public class SelectedTownFragment extends Fragment {

    private static String mainText = "Selected Town";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selected_town, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        TextView textView = view.findViewById(R.id.townText);
        mainText = getArguments() == null ? mainText : getArguments().getString("town_argument");
        textView.setText(mainText);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}