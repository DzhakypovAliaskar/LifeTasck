package com.example.lifetasck.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lifetasck.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDateBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
