package com.example.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class days extends AppCompatActivity {

    private List<word> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private word currentQuestion;
    ImageButton imgbutton;
    Button button_next;
    ImageView imageView;
    TextView txt_name;
    int r=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        txt_name = (TextView) findViewById(R.id.textView_name);
        button_next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAlldays();
        questionCountTotal = questionList.size();

        showNextQuestion();

        final int[] resI = {R.raw.monday,R.raw.tuesday,R.raw.wednesday,R.raw.thursday,R.raw.friday,R.raw.saturday,R.raw.sunday};
        final int[] audio={R.raw.monday1,R.raw.tuesday1,R.raw.wednesday1,R.raw.thursday1,R.raw.friday1,R.raw.saturday1,R.raw.sunday1};
        imageView = (ImageView) findViewById(R.id.imageButtonOne);
        imgbutton=(ImageButton) findViewById( R.id.imgbutton);
        imageView.setImageResource( resI[0] );
        button_next.setOnClickListener(new View.OnClickListener() {
            int i=1;

            @Override
            public void onClick(View v) {

                // imageButtonOne.setVisibility(View.VISIBLE);
                imageView.setImageResource(resI[i]);
                i++;
                r++;
                if (i==7) {
                    Intent intent=new Intent(days.this,LessonTwo.class);
                    startActivity(intent);
                }
                showNextQuestion();


            }


        });
        imgbutton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),audio[r]);

                mediaPlayer.start();

            }
        } );
    }


    public void showNextQuestion() {
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            txt_name.setText(currentQuestion.getName());

            questionCounter++;

        }
    }
}