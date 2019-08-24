package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

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
    }

    private void loadDatainListView() {
        arrayList=databaseHelper.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        li.setAdapter( myAdapter );
        myAdapter.notifyDataSetChanged();

    }
}
