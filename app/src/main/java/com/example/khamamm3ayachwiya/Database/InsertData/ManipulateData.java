package com.example.khamamm3ayachwiya.Database.InsertData;

import com.example.khamamm3ayachwiya.Database.Controller.QuestionController;
import com.example.khamamm3ayachwiya.Database.Controller.ScoreController;
import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;
import com.example.khamamm3ayachwiya.Database.Entities.Score;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManipulateData {
    private ScoreController scoreController;
    private QuestionController questionController;
    public ManipulateData(MyGameDatabase myGameDatabase){
        this.scoreController = new ScoreController(myGameDatabase);
        this.questionController = new QuestionController(myGameDatabase);
    }
    public void onCreate(){
        Score score = scoreController.getScore();
        if (score == null){
            scoreController.inserScore(initiateScore());
            questionController.insertAllQuestiones(initiateQuestionnes());
        }
    }
    private List<Questionnes> initiateQuestionnes(){
        List<Questionnes> questionnes = new ArrayList<Questionnes>();
        questionnes.add(new Questionnes("algeria",0));
        questionnes.add(new Questionnes("moroco",0));
        questionnes.add(new Questionnes("tunisia",0));
        questionnes.add(new Questionnes("libiya",0));
        questionnes.add(new Questionnes("mali",0));
        questionnes.add(new Questionnes("negeria",0));
        questionnes.add(new Questionnes("sodan",0));
        questionnes.add(new Questionnes("somal",0));
        return questionnes;
    }
    private Score initiateScore(){
        return new Score(0L,1);
    }

}
