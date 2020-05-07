package com.example.khamamm3ayachwiya.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.khamamm3ayachwiya.Database.MyGameDatabase;
import com.example.khamamm3ayachwiya.MainActivity;
import com.example.khamamm3ayachwiya.MyGame.GameController;
import com.example.khamamm3ayachwiya.R;

public class GameFragment extends Fragment {
    private Context context;
    private MyGameDatabase myGameDatabase;
    private GameController gameController;

    public GameFragment(Context context,MyGameDatabase myGameDatabase){
        this.context = context;
        this.myGameDatabase = myGameDatabase;
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.gamefragment,container,false);
        this.gameController = new GameController(this.context,this.myGameDatabase,view);
        return view;
    }

    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MyGameDatabase getMyGameDatabase() {
        return myGameDatabase;
    }

    public void setMyGameDatabase(MyGameDatabase myGameDatabase) {
        this.myGameDatabase = myGameDatabase;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
