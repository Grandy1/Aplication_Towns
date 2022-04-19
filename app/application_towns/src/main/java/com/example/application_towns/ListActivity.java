package com.example.application_towns;

import static com.example.application_towns.databinding.RecycleListItemBinding.inflate;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.application_towns.adapter.ListItemAdapter;
import com.example.application_towns.databinding.ActivityRecycleViewBinding;

public class ListActivity extends Activity {

    private ActivityRecycleViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String[] towns = getResources().getStringArray(R.array.towns);

        binding = ActivityRecycleViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WearableRecyclerView mRecyclerView = binding.recycleView;

        mRecyclerView.setLayoutManager(new WearableLinearLayoutManager(ListActivity.this));
        mRecyclerView.setAdapter(new ListItemAdapter(towns));
        mRecyclerView.setCircularScrollingGestureEnabled(true);
        mRecyclerView.setEdgeItemsCenteringEnabled(true);
    }
}