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

public class fruits extends AppCompatActivity {
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
        setContentView(R.layout.activity_fruits);
        txt_name = (TextView) findViewById(R.id.textView_name);
        button_next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAllfruits();
        questionCountTotal = questionList.size();

        showNextQuestion();

        final int[] resI = {R.raw.banana,R.raw.custard,R.raw.apple,R.raw.grapes,R.raw.jack,R.raw.mango,R.raw.orange1,R.raw.pineapple,R.raw.watermelon,R.raw.wood};
        final int[] audio={R.raw.banana1,R.raw.annamunna1,R.raw.apple1,R.raw.grapes1,R.raw.palappalam1,R.raw.orange2,R.raw.pineapple1,R.raw.watermelon1,R.raw.woodapple1};
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
                    Intent intent=new Intent(fruits.this,LessonTwo.class);
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