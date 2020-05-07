package com.example.khamamm3ayachwiya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.khamamm3ayachwiya.Animations.AnimationController;
import com.example.khamamm3ayachwiya.Database.Controller.QuestionController;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;

import org.w3c.dom.Text;

public class WinActivity extends AppCompatActivity {
    private AnimationController animationController;
    private ScoreController scoreController;
    private QuestionController questionController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        initiateControllers();
        displayWiningScreen();
    }


    private void displayWiningScreen(){
        TextView txt1 = (TextView) findViewById(R.id.finalStage);
        TextView txt2 = (TextView) findViewById(R.id.score);
        TextView txt3 = (TextView) findViewById(R.id.average);
        Button btn = (Button) findViewById(R.id.tryAgain);
        int questionNumber = questionController.getQuestionNumber();

        Long score = scoreController.getScore().getScore();
        txt3.setText(checks(questionNumber,score));
        txt2.setText(String.valueOf(score));
        animationController.setWinLeft(txt1);
        animationController.setWinLeft(txt3);
        animationController.setWinRight(txt2);
        animationController.setAnimationBottom(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreController.resetGame();
                questionController.resetQuestionne();
                Intent intent = new Intent(WinActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initiateControllers(){
        MyGameDatabase myGameDatabase = MyGameDatabase.getMyDatabase(getApplicationContext());
        animationController = new AnimationController(getApplicationContext());
        scoreController = new ScoreController(myGameDatabase);
        questionController = new QuestionController(myGameDatabase);
    }

    private String checks(int questionNumber,Long score){
        try {
            if (score <= questionNumber/questionNumber) {
                return "DO BETTER";
            } else if (  score <= questionNumber/6 && score > questionNumber/questionNumber ) {
                return "COOL";
            } else {
                return "GREATE";
            }
        }
        catch(ArithmeticException e){
            return "BAD";
        }

    }
}
