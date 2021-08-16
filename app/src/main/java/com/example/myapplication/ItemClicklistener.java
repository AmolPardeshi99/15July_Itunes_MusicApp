package com.example.myapplication;

public interface ItemClicklistener {
    void onPlayButtonCLicked(String url);
    void onPauseButtonCLicked();
    void onDeleteButtonClicked(ResultsModel resultsModel);
}
