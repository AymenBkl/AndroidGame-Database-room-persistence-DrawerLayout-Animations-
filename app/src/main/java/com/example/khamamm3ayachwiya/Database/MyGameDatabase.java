package com.example.khamamm3ayachwiya.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.khamamm3ayachwiya.Database.Doa.QuestionRepository;
import com.example.khamamm3ayachwiya.Database.Doa.ScoreRepository;
import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;
import com.example.khamamm3ayachwiya.Database.Entities.Score;
import com.example.khamamm3ayachwiya.Database.InsertData.ManipulateData;

@Database(entities = {Questionnes.class, Score.class} , version = 1 ,exportSchema = false)
public abstract class MyGameDatabase extends RoomDatabase {

    private static MyGameDatabase myGameDatabase;

    public abstract QuestionRepository questionRepository();
    public abstract ScoreRepository scoreRepository();

    public static MyGameDatabase getMyDatabase(Context context){
        if (myGameDatabase == null){
            synchronized (MyGameDatabase.class){
                if (myGameDatabase == null) {
                    myGameDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                        MyGameDatabase.class,"MyGameDatabase")
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }
        return myGameDatabase;
    }
}
