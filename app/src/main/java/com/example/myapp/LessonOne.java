package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LessonOne extends AppCompatActivity {

    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_lesson_one );


        Toolbar toolbar=findViewById(R.id.main_toolbar);
        TextView toolbarTitle=findViewById(R.id.titleText);

        toolbar.setTitle(" ");
        toolbarTitle.setText("Home/Lessons1");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linear1 = (LinearLayout) findViewById ( R.id.linear1 );
        linear1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        } );

        linear2 = (LinearLayout) findViewById ( R.id.linear2 );
        linear2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        } );

        linear3 = (LinearLayout) findViewById ( R.id.linear3 );
        linear3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        } );

        new SweetAlertDialog(this)
                .setTitleText("Here you can able to    practice writing and listening pronunciation of the letters ")
                .setConfirmButtonBackgroundColor(Color.parseColor("#49ACD5"))
                .show();
    }

    public void openActivity2(){
        Intent intent = new Intent ( this, Uyireluthu.class );
        startActivity ( intent );
    }

    public void openActivity3(){
        Intent intent = new Intent ( this, Meieluthu.class );
        startActivity ( intent );
    }

    public void openActivity4(){
        Intent intent = new Intent ( this, Uyirmeieluthu.class );
        startActivity ( intent );
    }


}
