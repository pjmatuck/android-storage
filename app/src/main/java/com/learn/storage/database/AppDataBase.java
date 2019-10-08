package com.learn.storage.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learn.storage.dao.UserDao;
import com.learn.storage.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    public static AppDataBase INSTANCE;

    public static AppDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room-test")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
