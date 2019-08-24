package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectTask extends AppCompatActivity {

    Button logout;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    Intent intentLogin;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_task);

        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        user usr = new user();

        usr.name = loginPreferences.getString("username","");




        textViewName = (TextView)findViewById(R.id.textViewName);

        logout = (Button)findViewById(R.id.btnLogout);
        intentLogin = new Intent(SelectTask.this,LoginActivity.class);

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


    public void toTaskOne(View view) {
        startActivity(new Intent(this, TaskCheck.class));
    }
    public void toTaskTwo(View view) {
        startActivity(new Intent(this, TaskTwo.class));
    }
    public void toTaskThree(View view) {
        startActivity(new Intent(this, QuizActivity.class));
    }

}
