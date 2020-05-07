package com.example.khamamm3ayachwiya.Database.Controller;

import com.example.khamamm3ayachwiya.Database.Doa.QuestionRepository;
import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;
import com.example.khamamm3ayachwiya.Database.MyGameDatabase;

import java.util.List;

public class QuestionController {
    private QuestionRepository questionRepository;
    public QuestionController(MyGameDatabase myGameDatabase){
        this.questionRepository = myGameDatabase.questionRepository();
    }
    public Long insertQuestion(Questionnes questionnes){
        return questionRepository.inserQuestion(questionnes);
    }
    public void insertAllQuestiones(List<Questionnes> questionnesList){
        questionRepository.insertAllQuestionnes(questionnesList);
    }
    public Questionnes getQuestion(int level){
        return questionRepository.getQuestionne((long) level);
    }
    public List<Questionnes> getAllQuestions(){
        return questionRepository.getAllQuestionnes();
    }

    public void resetTableQuestionnes(){

        questionRepository.resetQuestionnesTable();
    }

    public void setStatus(Long level){
        questionRepository.setStatus(level);
    }


}
