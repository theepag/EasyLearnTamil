package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LessonOne extends AppCompatActivity {

    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_lesson_one );

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
