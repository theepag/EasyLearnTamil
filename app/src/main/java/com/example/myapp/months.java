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

public class months extends AppCompatActivity {
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
        setContentView(R.layout.activity_months);
        txt_name = (TextView) findViewById(R.id.textView_name);
        button_next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAllmonths();
        questionCountTotal = questionList.size();

        showNextQuestion();

        final int[] resI = {R.raw.january,R.raw.febuary,R.raw.march,R.raw.april,R.raw.may,R.raw.june,R.raw.july,R.raw.august,R.raw.septemper,R.raw.october,R.raw.november,R.raw.december};
        final int[] audio={R.raw.january1,R.raw.febuary1,R.raw.march1,R.raw.april1,R.raw.may1,R.raw.june1,R.raw.july1,R.raw.august1,R.raw.september1,R.raw.october1,R.raw.november1,R.raw.december1};
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
                if (i==12) {
                    Intent intent=new Intent(months.this,LessonTwo.class);
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