package com.example.myapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class HighScore extends AppCompatActivity {
    DatabaseHelper db;
    TextView name_one,score_one,name_two,score_two,name_3,score_3,name_4,score_4,name_5,score_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        name_one = findViewById(R.id.name_one);
        name_two = findViewById(R.id.name_two);
        score_one = findViewById(R.id.score_one);
        score_two = findViewById(R.id.score_two);
        name_3 = findViewById(R.id.name_3);
        name_4 = findViewById(R.id.name_4);
        name_5= findViewById(R.id.name_5);
        score_3 = findViewById(R.id.score_3);
        score_4 = findViewById(R.id.score_4);
        score_5= findViewById(R.id.score_5);




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

        Cursor cursr=  db.getUser();
        StringBuilder stringBuildr=new StringBuilder();

        int z=0;
        final int[] userID= new int[400];
        final String[] name= new String[400];
        final String[] nameSorted= new String[400];


        while(cursr.moveToNext()){

            userID[z] = cursr.getInt(0);
            name[z] = cursr.getString(1);

            z++;

        }
        for (int a= 0; a < 400; a++) {

            for (int b= 0; b < 400; b++) {
                if (total[a][1] == userID[b]) {

                    nameSorted[a] = name[b];

                }

            }

        }


        score_one.setText(String.valueOf(total[1][0]));
        name_one.setText(String.valueOf(nameSorted[0]));
        score_two.setText(String.valueOf(total[2][0]));
        name_two.setText(String.valueOf(nameSorted[1]));
        score_3.setText(String.valueOf(total[3][0]));
        name_3.setText(String.valueOf(nameSorted[2]));
        score_4.setText(String.valueOf(total[4][0]));
        name_4.setText(String.valueOf(nameSorted[3]));
        score_5.setText(String.valueOf(total[5][0]));
        name_5.setText(String.valueOf(nameSorted[4]));










      //  Toast.makeText(getApplicationContext(),"updated " +total[1][0]+" "+ nameSorted[0]+" "+ total[2][0]+ " "+nameSorted[1] ,Toast.LENGTH_SHORT).show();



    }
}
