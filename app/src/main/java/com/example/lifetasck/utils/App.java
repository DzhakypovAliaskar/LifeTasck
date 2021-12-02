package com.example.lifetasck.utils;

import android.app.Application;

import androidx.room.Room;

import com.example.lifetasck.room.AppDateBase;

public class App extends Application {
    public static App instance;

    private AppDateBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDateBase.class, "database").allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDateBase getDatabase() {
        return database;
    }
}

