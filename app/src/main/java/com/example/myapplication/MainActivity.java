package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClicklistener{
    private Button mBtnSearch;
    private EditText mEtArtistName;
    private List<ResultsModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnSearch = findViewById(R.id.btnSearch);
        mEtArtistName = findViewById(R.id.etArtistName);
        mediaPlayer = new MediaPlayer();
        recyclerView = findViewById(R.id.recyclerview);
        mBtnSearch.setOnClickListener(v -> {
            callAPi();
        });
    }

    private void callAPi() {
        APIService  apiService = Network.getInstance().create(APIService.class);
        String artistname = mEtArtistName.getText().toString();
        apiService.getSong(artistname).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() !=null){
                    list = response.body().getResults();
                    setRecyclerview();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void setRecyclerview() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        songAdapter = new SongAdapter(list,this);
        recyclerView.setAdapter(songAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }


    @Override
    public void onPlayButtonCLicked(String url) {
        mediaPlayer.reset();
        Uri uri = Uri.parse(url);
        mediaPlayer = MediaPlayer.create(this,uri);
        mediaPlayer.start();
    }

    @Override
    public void onPauseButtonCLicked() {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDeleteButtonClicked(ResultsModel resultsModel) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        list.remove(resultsModel);
        songAdapter.notifyDataSetChanged();
    }
}