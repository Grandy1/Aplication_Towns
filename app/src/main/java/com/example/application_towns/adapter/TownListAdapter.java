package com.example.application_towns.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application_towns.R;

import java.util.List;

public class TownListAdapter extends RecyclerView.Adapter<TownListAdapter.RecyclerViewHolder> {

    String[] towns;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView itemTextView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.townText);
        }

        public TextView getItemTextView () {
            return itemTextView;
        }
    }

    public TownListAdapter(String[] TownDataset) {
        towns = TownDataset;
    }

    @NonNull
    @Override
    public TownListAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TownListAdapter.RecyclerViewHolder holder, int position) {
        holder.getItemTextView().setText(towns[position]);
    }

    @Override
    public int getItemCount() {
        return towns.length;
    }
}
