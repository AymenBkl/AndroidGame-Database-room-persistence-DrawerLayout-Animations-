package com.example.khamamm3ayachwiya.Database.Doa;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.khamamm3ayachwiya.Database.Entities.Score;


@Dao
public interface ScoreRepository{
    @Insert
    Long insertScore(Score score);

    @Query("UPDATE score SET level = level + 1 ,score = score+1 WHERE id = 1")
    void updateScore();
    @Query("UPDATE score SET level = level +1 WHERE id= 1")
    void nextLevel();
    @Query("UPDATE score SET level = level - 1 WHERE id= 1")
    void prevuoisLevel();
    @Query("UPDATE score SET level = 1,score = 0,id = 1 WHERE id = 1")
    void resetScore();

    @Query("SELECT * FROM score WHERE id = 1")
    Score getScore();

    @Query("DELETE FROM score")
    void resetScoreTable();

}
