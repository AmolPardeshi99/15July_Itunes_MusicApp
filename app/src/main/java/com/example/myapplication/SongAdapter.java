package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private List<ResultsModel> modelList;
    private ItemClicklistener itemClicklistener;

    public SongAdapter(List<ResultsModel> modelList, ItemClicklistener itemClicklistener) {
        this.modelList = modelList;
        this.itemClicklistener = itemClicklistener;
    }

    @NonNull
    @NotNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SongViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false), itemClicklistener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SongViewHolder holder, int position) {
        ResultsModel resultsModel = modelList.get(position);
        holder.setData(resultsModel);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
