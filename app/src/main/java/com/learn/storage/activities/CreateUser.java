package com.learn.storage.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.learn.storage.R;
import com.learn.storage.dao.UserDao;
import com.learn.storage.database.AppDataBase;
import com.learn.storage.model.User;

public class CreateUser extends AppCompatActivity {

    AppDataBase db;

    EditText et_first_name, et_last_name, et_skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        db = AppDataBase.getAppDatabase(getApplicationContext());

        et_first_name = findViewById(R.id.et_first_name);
        et_last_name = findViewById(R.id.et_last_name);
        et_skill = findViewById(R.id.et_skill);
    }

    public void saveUser(View view){
        UserDao userDao = db.userDao();
        User user = new User(
                et_first_name.getText().toString(),
                et_last_name.getText().toString(),
                et_skill.getText().toString()
        );
        try {
            userDao.insertUser(user);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
