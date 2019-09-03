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
        final int[][] total= new int[400][2];

        int i=0;
        int j=0;
        while(cursor.moveToNext()){
            //   stringBuilder.append(cursor.getString(2));


            level1[i] = cursor.getInt(1);
            level2[i] = cursor.getInt(2);
            level3[i] = cursor.getInt(3);

            total[i][0] = level1[i] + level2[i] + level3[i];
            total[i][1] = cursor.getInt(0);
            i++;

        }

        int temp,temp2;
        for (int k =0; k < 400; k++) {
            for (int l = k+ 1; l < 400; l++ ) {
                if (total[k][0] < total[l][0])
                {
                    temp = total[k][0];
                    temp2 = total[k][1];

                    total[k][0] = total[l][0];
                    total[k][1] = total[l][1];
                    total[l][0] = temp;
                    total[l][1] = temp2;

                }

            }
        }


        Toast.makeText(getApplicationContext(),"updated " + total[0][0]+" "+ total[0][1] +" "+total[1][0]+" "+ total[1][1] ,Toast.LENGTH_SHORT).show();



    }
}
