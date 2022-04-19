package com.example.application_towns.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.WearableRecyclerView;

import com.example.application_towns.R;

public class ListItemAdapter extends WearableRecyclerView.Adapter<ListItemAdapter.RecyclerViewHolder> {

    String[] towns;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView itemTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.townText);
        }

        public TextView getItemTextView () {
            return itemTextView;
        }
    }

    public ListItemAdapter(String[] TownDataset) {
        towns = TownDataset;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, final int position) {
        viewHolder.getItemTextView().setText(towns[position]);
    }

    @Override
    public int getItemCount() {
        return towns.length;
    }
}
