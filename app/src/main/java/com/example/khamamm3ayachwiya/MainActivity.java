package com.example.khamamm3ayachwiya;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Database.InsertData.ManipulateData;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;
import com.example.khamamm3ayachwiya.Dialogs.DialogController;
import com.example.khamamm3ayachwiya.Fragments.GameFragment;
import com.google.android.material.navigation.NavigationView;

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
        ScoreController scoreController = new ScoreController(myGameDatabase);
        if (scoreController.getScore().getLevel() > 8){
            Intent intent = new Intent(MainActivity.this, WinActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void initiateFragment(){
        gameFragment = new GameFragment(MainActivity.this,myGameDatabase);
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
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        };
        return super.onOptionsItemSelected(item);
    }
}
