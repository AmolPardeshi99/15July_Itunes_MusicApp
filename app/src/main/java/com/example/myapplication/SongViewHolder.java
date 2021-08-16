package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class SongViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvSongName, mTvArtistName;
    private ImageButton mBtnPlay, mBtnPause, mBtnDelete;
    private ImageView mIvSongImage;
    private ItemClicklistener itemClicklistener;
    public SongViewHolder(@NonNull @NotNull View itemView,ItemClicklistener itemClicklistener) {
        super(itemView);
        this.itemClicklistener = itemClicklistener;
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvArtistName = itemView.findViewById(R.id.tvArtistName);
        mTvSongName = itemView.findViewById(R.id.tvSongName);
        mIvSongImage = itemView.findViewById(R.id.ivSongImage);
        mBtnDelete = itemView.findViewById(R.id.btnDelete);
        mBtnPause = itemView.findViewById(R.id.btnPause);
        mBtnPlay = itemView.findViewById(R.id.btnPlay);
    }

    public void setData(ResultsModel resultsModel){
        Glide.with(mIvSongImage).load(resultsModel.getArtworkUrl100()).into(mIvSongImage);
        mTvSongName.setText(resultsModel.getTrackName());
        mTvArtistName.setText(resultsModel.getArtistName());

        mBtnPlay.setOnClickListener(v -> {
            itemClicklistener.onPlayButtonCLicked(resultsModel.getPreviewUrl());
        });

        mBtnPause.setOnClickListener(v -> {
            itemClicklistener.onPauseButtonCLicked();
        });

        mBtnDelete.setOnClickListener(v -> {
            itemClicklistener.onDeleteButtonClicked(resultsModel);
        });
    }
}
