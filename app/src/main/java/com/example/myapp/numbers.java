package com.example.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class numbers extends AppCompatActivity {
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
        setContentView(R.layout.activity_numbers);

        Toolbar toolbar=findViewById(R.id.main_toolbar);
        TextView toolbarTitle=findViewById(R.id.titleText);

        toolbar.setTitle(" ");
        toolbarTitle.setText("Home/Lessons/Lesson2/Numbers");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_name = (TextView) findViewById(R.id.textView_name);
        button_next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAllnum();
        questionCountTotal = questionList.size();

        showNextQuestion();

        final int[] resI = {R.raw.one,R.raw.two,R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,R.raw.nine,R.raw.ten};
        final int[] audio={R.raw.one1,R.raw.two1,R.raw.three1,R.raw.four1,R.raw.five1,R.raw.six1,R.raw.seven1,R.raw.eight1,R.raw.nine1,R.raw.ten1};
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
                if (i==10) {
                    Intent intent=new Intent(numbers.this,LessonTwo.class);
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