package com.example.khamamm3ayachwiya.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.khamamm3ayachwiya.Database.Controller.QuestionController;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Fragments.GameFragment;
import com.example.khamamm3ayachwiya.WinActivity;

public class DialogController {
    private GameFragment gameFragment;
    private Context context;
    private DrawerLayout drawerLayout;
    private ScoreController scoreController;
    private QuestionController questionController;
    public DialogController(Context context,GameFragment gameFragment,DrawerLayout drawerLayout){
        this.context = context;
        this.gameFragment = gameFragment;
        this.drawerLayout = drawerLayout;
        this.scoreController = new ScoreController(gameFragment.getMyGameDatabase());
        this.questionController = new QuestionController(gameFragment.getMyGameDatabase());
    }
    public void buildNextLevelDialog() {
        AlertDialog.Builder nextLevelDialog = new AlertDialog.Builder(context);
        nextLevelDialog.setTitle("Warning")
                .setMessage("You're score won't be counted")
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        if (scoreController.nextLevel(gameFragment.getGameController().getCurrentScore().getLevel())) {
                            questionController.setStatus((long) gameFragment.getGameController().getCurrentScore().getLevel());
                            gameFragment.getGameController().resetAll();
                        } else {
                            Intent intent = new Intent(context, WinActivity.class);
                            context.startActivity(intent);
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    public void buildPrevuoisLevelDialog() {
        AlertDialog.Builder prevuoisLevel = new AlertDialog.Builder(context);
        prevuoisLevel.setTitle("Alert")
                .setMessage("Are you sure ?")
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        if (scoreController.prevouisLevel(gameFragment.getGameController().getCurrentScore().getLevel())) {
                            gameFragment.getGameController().resetAll();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    public void buildResetGame() {
        AlertDialog.Builder resetGame = new AlertDialog.Builder(context);
        resetGame.setTitle("Danger")
                .setMessage("You score will be reseted")
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        gameFragment.getMyGameDatabase().scoreRepository().resetScore();
                        gameFragment.getGameController().resetAll();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }
}
