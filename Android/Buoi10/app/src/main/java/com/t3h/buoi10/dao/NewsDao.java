package com.t3h.buoi10.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.t3h.buoi10.model.News;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE id = :id")
    News getNewsFromID(long id);

    @Insert
    void insert(News ... news);

    @Delete
    void delete(News ... news);

    @Query("DELETE FROM news")
    void deleteAll();

    @Update
    void update(News ... news);
}
