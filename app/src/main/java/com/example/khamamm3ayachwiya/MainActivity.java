package com.example.khamamm3ayachwiya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khamamm3ayachwiya.Database.Controller.QuestionController;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;
import com.example.khamamm3ayachwiya.Database.Entities.Score;
import com.example.khamamm3ayachwiya.Database.InsertData.ManipulateData;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;
import com.example.khamamm3ayachwiya.Dialogs.DialogController;
import com.example.khamamm3ayachwiya.Fragments.GameFragment;
import com.example.khamamm3ayachwiya.MyGame.GameController;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Context context;
    private GameFragment gameFragment;
    private DialogController dialogController;
    private MyGameDatabase myGameDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        initiateDatabase();
        initiateFragment();
        setDrawerLayout();
        dialogController = new DialogController(MainActivity.this,gameFragment,drawerLayout);
        setNaviagtionMenu();

    }
    private void initiateDatabase(){
        this.myGameDatabase = MyGameDatabase.getMyDatabase(getApplicationContext());
        ManipulateData manipulateData = new ManipulateData(myGameDatabase);
        manipulateData.onCreate();
    }
    private void initiateFragment(){
        gameFragment = new GameFragment(context,myGameDatabase);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.gameFragmentHolder,gameFragment);
        fragmentTransaction.commit();
    }
    private void setNaviagtionMenu(){
        navigationView = (NavigationView) findViewById(R.id.gameNavigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nextLevel :
                        dialogController.buildNextLevelDialog();
                        return true;
                    case R.id.previousLevel :
                        dialogController.buildPrevuoisLevelDialog();
                        return true;
                    case R.id.reset :
                        dialogController.buildResetGame();
                        return true;
                }
                return true;
            }
        });
    }
    public void setDrawerLayout(){
        drawerLayout = (DrawerLayout) findViewById(R.id.gameMenu);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
