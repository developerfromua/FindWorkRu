package com.rsoftware.findworkru.model.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {FavouriteList.class, Resume.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database database;
    private static final String DB_NAME = "favourite7.db";
    private static final Object LOCK = new Object();

    public static Database getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, Database.class, DB_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return database;
    }
    public abstract FavouriteDao favouriteDao();
    public abstract ResumeDao resumeDao();
}
