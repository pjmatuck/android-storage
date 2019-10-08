package com.learn.storage.activities;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.learn.storage.R;
import com.learn.storage.dao.UserDao;
import com.learn.storage.database.AppDataBase;
import com.learn.storage.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppDataBase db;
    UserDao userDao;
    List<User> users;
    ListView listViewDBNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDBNames = findViewById(R.id.lv_db_names);
        toolbar = findViewById(R.id.mainToolBar);
        setSupportActionBar(toolbar);

        db = AppDataBase.getAppDatabase(getApplicationContext());

        userDao = db.userDao();

    }

    @Override
    protected void onResume() {
        super.onResume();
        users = userDao.getAll();

        ArrayList<String> idsAndNames = new ArrayList<String>();

        if(users.size() > 0) {
            for (User u : users) {
                idsAndNames.add(u.getId() + " " + u.getFirstName());
            }
//            for (User u : users) {
//                Toast.makeText(getApplicationContext(), u.getId() + " " + u.getFirstName() + "\n", Toast.LENGTH_SHORT).show();
//            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, idsAndNames);
            arrayAdapter.notifyDataSetChanged();
            listViewDBNames.setAdapter(arrayAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.register_users:
                //Call activity to register Users
                Intent intent = new Intent(this, CreateUser.class);
                startActivity(intent);
                break;
            case R.id.register_projects:
                //Call activity to register Projects
                break;
        }
        return true;
    }
}
