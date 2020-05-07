package com.example.khamamm3ayachwiya.MyGame;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.khamamm3ayachwiya.Database.Controller.QuestionController;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;
import com.example.khamamm3ayachwiya.Database.Entities.Score;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;
import com.example.khamamm3ayachwiya.Generators.ViewGenerator;
import com.example.khamamm3ayachwiya.R;



public class GameController {
    private GameBuilder gameBuilder;
    private ScoreController scoreController;
    private QuestionController questionController;
    private Game game;
    private View view;
    private Context context;
    private Questionnes currentQuestion;
    private Score currentScore;
    private ViewGenerator viewGenerator;

    public GameController(Context context,MyGameDatabase myGameDatabase,View view){
        this.context = context;
        this.scoreController = new ScoreController(myGameDatabase);
        this.questionController = new QuestionController(myGameDatabase);
        this.view = view;
        this.viewGenerator = new ViewGenerator(this.context,view);
        resetAll();
        setClick();
    }
    public void resetAll(){
        this.viewGenerator.resetLinearLayout();
        this.gameBuilder = new GameBuilder();
        this.game = this.gameBuilder.reset();
        this.currentScore = this.scoreController.getScore();
        this.currentQuestion = questionController.getQuestion(currentScore.getLevel());
        this.viewGenerator.editScore(currentScore.getScore());
        buildGame();
    }

    public void buildGame(){
        String question = this.currentQuestion.getQuestion();
        int lenQuestion = question.length();

        this.gameBuilder.buildTextView1(this.viewGenerator.createTextView(0,String.valueOf(question.charAt(0))));
        for(int i = 1;i<lenQuestion-1;i++){
            this.gameBuilder.buildEditText(this.viewGenerator.createEditText(i));
        }
        this.gameBuilder.buildTextView2(this.viewGenerator.createTextView(lenQuestion-1,String.valueOf(question.charAt(lenQuestion-1))));
        this.game =  this.gameBuilder.getGame();
    }
    public void setClick(){
        Button btn = (Button) this.view.findViewById(R.id.checks);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question =  currentQuestion.getQuestion();
               String check = question.charAt(0) +  game.checks() + question.charAt(question.length()-1);
               if (check.equalsIgnoreCase(question)){
                   questionController.setStatus((long) currentScore.getLevel());
                  scoreController.winLevel(currentScore.getLevel(),currentQuestion.getStatus());
                  resetAll();
               }
               else {
                   Toast.makeText(context,"nomatch",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }


    public Questionnes getCurrentQuestion() {

        return currentQuestion;
    }

    public void setCurrentQuestion(Questionnes currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public Score getCurrentScore() {

        return currentScore;
    }

    public void setCurrentScore(Score currentScore) {

        this.currentScore = currentScore;
    }
}
