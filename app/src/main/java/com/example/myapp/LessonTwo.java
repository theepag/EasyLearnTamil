package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LessonTwo extends AppCompatActivity {
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    LinearLayout l4;
    LinearLayout l5;
    LinearLayout l6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_two);
        l1=(LinearLayout) findViewById(R.id.l1);
        l3=(LinearLayout) findViewById( R.id.l3 );
        l2=(LinearLayout) findViewById(R.id.l2);
        l4=(LinearLayout) findViewById( R.id.l4 );
        l5=(LinearLayout) findViewById( R.id.l5 );
        l6=(LinearLayout) findViewById( R.id.l6 );


        l6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,months.class);
                startActivity(intent);
            }
        } );
        l5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,days.class);
                startActivity(intent);
            }
        } );

        l4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,colours.class);
                startActivity(intent);
            }
        } );

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,relation.class);
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,numbers.class);
                startActivity(intent);
            }
        });
        l3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LessonTwo.this,fruits.class);
                startActivity(intent);
            }
        } );
    }
}