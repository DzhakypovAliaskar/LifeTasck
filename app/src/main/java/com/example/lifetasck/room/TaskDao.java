package com.example.lifetasck.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lifetasck.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(TaskModel model);

    @Update
    void update(TaskModel model);

    @Query("SELECT * FROM taskmodel")
    LiveData<List<TaskModel>> getAll();

    @Delete
    void delete(TaskModel model);
}
