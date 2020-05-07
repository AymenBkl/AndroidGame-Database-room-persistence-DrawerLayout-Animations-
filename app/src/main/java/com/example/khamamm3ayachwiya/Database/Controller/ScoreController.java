package com.example.khamamm3ayachwiya.Database.Controller;


import com.example.khamamm3ayachwiya.Database.Doa.ScoreRepository;
import com.example.khamamm3ayachwiya.Database.Entities.Score;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;

public class ScoreController {
    private ScoreRepository scoreRepository;
    public ScoreController(MyGameDatabase myGameDatabase){
        this.scoreRepository = myGameDatabase.scoreRepository();
    }

    public Score getScore(){
        return scoreRepository.getScore();
    }
    public boolean nextLevel(int currentLevel){
        if (currentLevel < 8){
            scoreRepository.nextLevel();
            return true;
        }
        else {
            scoreRepository.nextLevel();
            return false;
        }
    }
    public boolean prevouisLevel(int currentLevel){
        if (currentLevel == 1){
            return false;
        }
        else {
            scoreRepository.prevuoisLevel();
            return true;
        }
    }
    public void resetGame(){
        scoreRepository.resetScore();
    }
    public boolean winLevel(int currentLevel,int status){
        if (currentLevel < 8) {
            if (checks(status)) {
                scoreRepository.updateScore();
            }
            else {
                scoreRepository.nextLevel();
            }
            return true;
        }
        else {
            if (checks(status)) {
                scoreRepository.updateScore();
            }
            else {
                scoreRepository.nextLevel();
            }
            return false;
        }
    }
    public Long inserScore(Score score){

        return scoreRepository.insertScore(score);
    }

    private boolean checks(int status){
        if (status == 0){
            return true;
        }
        else {
            return false;
        }
    }

}
