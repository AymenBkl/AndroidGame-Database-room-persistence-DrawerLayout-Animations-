package com.example.khamamm3ayachwiya.MyGame;

import android.widget.EditText;
import android.widget.TextView;

import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Questionnes question;
    private List<EditText> editTexts;
    private TextView txt1;
    private TextView txt2;

    public Game(){
        this.editTexts = new ArrayList<EditText>();
    }
    public Questionnes getQuestion() {
        return question;
    }

    public void setQuestion(Questionnes question) {
        this.question = question;
    }

    public List<EditText> getEditTexts() {
        return editTexts;
    }

    public void setEditTexts(List<EditText> editTexts) {
        this.editTexts = editTexts;
    }

    public TextView getTxt1() {
        return txt1;
    }

    public void setTxt1(TextView txt1) {
        this.txt1 = txt1;
    }

    public TextView getTxt2() {
        return txt2;
    }

    public void setTxt2(TextView txt2) {
        this.txt2 = txt2;
    }

    public void addTextEdit(EditText editText){
        this.editTexts.add(editText);
    }
    public String checks(){
        String check = "";
        for(EditText editText : editTexts){
            check += editText.getText();
        }
        return check;
    }
}
