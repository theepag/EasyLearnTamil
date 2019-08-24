package com.example.myapp;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TaskCheck extends AppCompatActivity {

    ImageButton btnPlays,buttonNxt,btnN;
    Button btnstart;
    DatabaseHelper db;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    TextView textViewName,textViewOne,textViewTwo,textViewThree,textViewFour,textViewScore,textViewSname,textViewc1,textViewc2,TextViewLevel;
    Dialog level_finished;

    final int[] resID = {R.raw.a,R.raw.a,R.raw.aa,R.raw.e,R.raw.ee,R.raw.u,R.raw.uu,R.raw.ea,R.raw.eaa,R.raw.i,R.raw.o,R.raw.oo,R.raw.aw};

    public int score =0;
    public int random;
    public int[] c= new int[8];
    public int[] index= new int[4];
    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_check);

        db=new DatabaseHelper(this);

        Cursor cursor=db.viewData();
        StringBuilder stringBuilder=new StringBuilder();
        final String[] arr= new String[400];
        int i=0;
        while(cursor.moveToNext()){
            //   stringBuilder.append(cursor.getString(2));

            arr[i] = cursor.getString(1);
            i++;
        }

        level_finished = new Dialog(this);

        btnPlays = findViewById(R.id.playSoundBtn2);
        btnstart = findViewById(R.id.buttonStart);

        buttonNxt = findViewById(R.id.buttonNxt);
        textViewOne = findViewById(R.id.textViewOne);
        textViewTwo = findViewById(R.id.textViewTwo);
        textViewThree = findViewById(R.id.textViewThree);
        textViewFour = findViewById(R.id.textViewFour);
        textViewScore = findViewById(R.id.textViewScore);
        textViewSname = findViewById(R.id.textView10);
        textViewc1 = findViewById(R.id.textView18);
        textViewc2 = findViewById(R.id.textView19);
        TextViewLevel = findViewById(R.id.textView8);
        textViewName = findViewById(R.id.textView12);



        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnstart.setVisibility(View.INVISIBLE);
                btnPlays.setVisibility(View.VISIBLE);
                buttonNxt.setVisibility(View.VISIBLE);
                textViewScore.setVisibility(View.VISIBLE);
                textViewc1.setVisibility(View.VISIBLE);
                textViewc2.setVisibility(View.VISIBLE);
                TextViewLevel.setVisibility(View.VISIBLE);

                textViewSname.setVisibility(View.VISIBLE);
                textViewName.setVisibility(View.VISIBLE);


                buttonNxt.performClick();

            }
        });


        buttonNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count==10) {

                        updatescore(score);

                        if (score >= 70) {

                            showSuccessMessage();
                            updatescore(score);
                        }

                        else {
                            showUncompletedMessage();
                            updatescore(score);
                        }



                }
                genRandom();
                btnstart.setVisibility(View.INVISIBLE);
                textViewOne.setBackgroundColor(0);
                textViewTwo.setBackgroundColor(0);
                textViewThree.setBackgroundColor(0);
                textViewFour.setBackgroundColor(0);



                textViewOne.setText(arr[c[index[0]]]);
                textViewTwo.setText(arr[c[index[1]]]);
                textViewThree.setText(arr[c[index[2]]]);
                textViewFour.setText(arr[c[index[3]]]);

            }
        });

        btnPlays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),resID[random]);
                mediaPlayer.start();
                btnstart.setVisibility(View.INVISIBLE);



            }
        });

        textViewOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String input = textViewOne.getText().toString();
                if (input == arr[random]) {




                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    buttonNxt.performClick();

                } else {

                    textViewOne.setBackgroundColor(0xFFFF0000);

                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String input = textViewTwo.getText().toString();
                if (input == arr[random]) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));

                    buttonNxt.performClick();

                } else {

                    textViewTwo.setBackgroundColor(0xFFFF0000);

                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String input = textViewThree.getText().toString();
                if (input == arr[random]) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));

                    buttonNxt.performClick();

                } else {
                    textViewThree.setBackgroundColor(0xFFFF0000);

                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewFour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String input = textViewFour.getText().toString();
                if (input == arr[random]) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));

                    buttonNxt.performClick();

                } else {
                    textViewFour.setBackgroundColor(0xFFFF0000);
                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void genRandom() {
        count +=1;
        int r = (int) (Math.random() * (13 - 1)) + 1;
        random = r;


        c[0]= random;
        for (int i=1; i<8; i++) {
            int k = (int) (Math.random() * (13 - 1)) + 1;
            if(k != random && k != c[1] && k != c[2] && k != c[3]) {
                c[i] = k;
            } else {  i = i-1;}

        }
        for (int i = 0; i < 4; i++) {
            index[i] = (int)(Math.random()*4);//note, this generates numbers from [0,9]

            for (int j = 0; j < i; j++) {
                if (index[i] == index[j]) {
                    i--;
                    break;
                }
            }
        }

    }
    public void showSuccessMessage() {
        TextView Congra,level;
        Button btnclk;

        Congra = findViewById(R.id.congrats);

        level = findViewById(R.id.levelname);

        btnclk = (Button)findViewById(R.id.button4);

        level_finished.setContentView(R.layout.level_finished);
        level_finished.show();




    }
    public void showUncompletedMessage() {


        level_finished.setContentView(R.layout.level_uncompleted);
        level_finished.show();




    }
    public void updatescore(int score) {

        String id =loginPreferences.getString("userid","");

        boolean chkupdated = db.updateScore(score,id);
        if (chkupdated = true) {

            Cursor cursor=  db.viewScore(id);
            StringBuilder stringBuilder=new StringBuilder();
            final String[] arr2= new String[400];
            int i=0;
            while(cursor.moveToNext()){
                //   stringBuilder.append(cursor.getString(2));

                arr2[i] = cursor.getString(1);
                i++;
            }


            Toast.makeText(getApplicationContext(),"updated "+ score+" "+ arr2[0],Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(getApplicationContext(),"Not updated",Toast.LENGTH_SHORT).show();
        }



    }
}
