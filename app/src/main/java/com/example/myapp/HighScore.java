package com.example.myapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class HighScore extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        db=new DatabaseHelper(this);
        Cursor cursor=  db.viewHighScore();
        StringBuilder stringBuilder=new StringBuilder();
        final int[] id= new int[400];
        final int[] level1= new int[400];
        final int[] level2= new int[400];
        final int[] level3= new int[400];
        final int[] total= new int[400];

        int i=0;
        while(cursor.moveToNext()){
            //   stringBuilder.append(cursor.getString(2));

            id[i] = cursor.getInt(0);
            level1[i] = cursor.getInt(1);
            level2[i] = cursor.getInt(2);
            level3[i] = cursor.getInt(3);
            total[i] = level1[i] + level2[i] + level3[i];

            i++;
        }

        Toast.makeText(getApplicationContext(),"updated "+ id[1] + " " + level1[1]+" "+ total[1]+" "+ level3[1],Toast.LENGTH_SHORT).show();



    }
}
