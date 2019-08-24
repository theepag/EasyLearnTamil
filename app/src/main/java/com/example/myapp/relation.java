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

public class relation extends AppCompatActivity {
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
        setContentView(R.layout.activity_relation);
        txt_name = (TextView) findViewById(R.id.textView_name);
        button_next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();

        showNextQuestion();

        final int[] resI = {R.raw.mother1,R.raw.father,R.raw.sister,R.raw.brother,R.raw.grandfather,R.raw.grandmother,R.raw.uncle,R.raw.mami,R.raw.siththi,R.raw.sithappa};
        final int[] audio={R.raw.amma,R.raw.appa,R.raw.sister1,R.raw.brother1,R.raw.grandfather1,R.raw.grandmother1,R.raw.mama,R.raw.atthai,R.raw.siththi1,R.raw.siththappa1};
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
                    Intent intent=new Intent(relation.this,LessonTwo.class);
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