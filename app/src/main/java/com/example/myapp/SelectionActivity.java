package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectionActivity extends AppCompatActivity {
    Button logout;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    Intent intentLogin;
    TextView textViewName;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        user usr = new user();

        usr.name = loginPreferences.getString("username","");
        db=new DatabaseHelper(this);

        Cursor cursor=db.getUserdetails(usr.name);


        while(cursor.moveToNext()){
            usr.email= cursor.getString(2);
            usr.last_level= cursor.getInt(5);
            usr.id = cursor.getString(0);

        }

        loginPrefsEditor = loginPreferences.edit();
       loginPrefsEditor.putString("userid",usr.id);
       loginPrefsEditor.commit();

        textViewName = (TextView)findViewById(R.id.textViewName);

        logout = (Button)findViewById(R.id.btnLogout);
        intentLogin = new Intent(SelectionActivity.this,LoginActivity.class);

        textViewName.setText(usr.id);

        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = loginPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(intentLogin);


            }
        });

        if (loginPreferences.getString("username","")== null) {

            startActivity(intentLogin);

        }


    }

    public void toLessons (View view) {
        startActivity(new Intent(this, SelectLesson.class));
    }

    public void toTasks (View view) {
        startActivity(new Intent(this, SelectTask.class));
    }

    public void toHighScore (View view) {
        startActivity(new Intent(this, HighScore.class));
    }






}
