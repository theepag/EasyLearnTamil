package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LessonThree extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView li;
    ArrayList<word> arrayList;
    Button recordNow;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lesson_three );

        Toolbar toolbar=findViewById(R.id.main_toolbar);
        TextView toolbarTitle=findViewById(R.id.titleText);

        toolbar.setTitle(" ");
        toolbarTitle.setText("Home/Lessons/Lesson3/Dialouge");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recordNow=(Button) findViewById( R.id.recordNow );
        databaseHelper=new DatabaseHelper( this );
        li=(ListView) findViewById( R.id.listView );
        recordNow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( LessonThree.this,record.class );
                startActivity( intent );

            }
        } );
        arrayList=new ArrayList<>(  );
        loadDatainListView();

        new SweetAlertDialog(this)
                .setTitleText("Here you can able to learn day to day dialogues ")
                .setConfirmButtonBackgroundColor(Color.parseColor("#49ACD5"))
                .show();

    }

    private void loadDatainListView() {
        arrayList=databaseHelper.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        li.setAdapter( myAdapter );
        myAdapter.notifyDataSetChanged();

    }
}
