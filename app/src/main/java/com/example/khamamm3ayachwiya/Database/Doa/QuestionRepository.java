package com.example.khamamm3ayachwiya.Database.Doa;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.khamamm3ayachwiya.Database.Entities.Questionnes;

import java.util.List;
@Dao
public interface QuestionRepository {

    @Insert
    long inserQuestion(Questionnes questionnes);

    @Insert
    void insertAllQuestionnes(List<Questionnes> questionnes);

    @Query("SELECT * FROM questionnes")
    List<Questionnes> getAllQuestionnes();

    @Query("SELECT * FROM questionnes WHERE id = :position")
    Questionnes getQuestionne(Long position);

    @Query("DELETE FROM questionnes")
    void resetQuestionnesTable();

    @Query("UPDATE questionnes SET status = 0 WHERE id = :position")
    void setStatus(Long position);


}
