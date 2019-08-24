package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectLesson extends AppCompatActivity {
//Button l2;
    Button logout;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    Intent intentLogin;
    TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lesson);
        //l2=(Button) findViewById(R.id.btnLessonTwo);

        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        user usr = new user();

        usr.name = loginPreferences.getString("username","");




        textViewName = (TextView)findViewById(R.id.textViewName);

        logout = (Button)findViewById(R.id.btnLogout);
        intentLogin = new Intent(SelectLesson.this,LoginActivity.class);

        textViewName.setText(loginPreferences.getString("username",""));

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

    public void toLessonOne(View view) {
        startActivity(new Intent(this, LessonOne.class));
    }
    public void toLessonTwo(View view) {
        startActivity(new Intent(this, LessonTwo.class));
    }

    public void toLessonThree(View view) {
        startActivity(new Intent(this, LessonThree.class));
    }
}
