package com.example.khamamm3ayachwiya.MyGame;

import android.widget.EditText;
import android.widget.TextView;

import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;

public class GameBuilder {

    private Game game;

    public GameBuilder(){

    }

    public Game reset(){
        this.game = new Game();
        return this.game;
    }
    public GameBuilder buildQuestionne(Questionnes question){
        this.game.setQuestion(question);
        return this;
    }
    public GameBuilder buildEditText(EditText editText){
        this.game.addTextEdit(editText);
        return this;
    }
    public GameBuilder buildTextView1(TextView txt1){
        this.game.setTxt1(txt1);
        return this;
    }
    public GameBuilder buildTextView2(TextView txt2){
        this.game.setTxt2(txt2);
        return this;
    }

    public Game getGame(){
        return this.game;
    }

}
