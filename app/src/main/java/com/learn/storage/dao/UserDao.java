package com.learn.storage.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.learn.storage.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insertUser(User... user);
}
