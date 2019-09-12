package com.example.myapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapp.R;

import java.util.Arrays;
import java.util.Collections;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class TaskTwo extends AppCompatActivity {

    private ImageView ImageView;
    private ImageView ImageView1;
    private ImageView ImageView2;
    private ImageView ImageView3;
    private TextView TextView;
    private TextView textViewScore;
    private Button Button;
    DatabaseHelper db;
    SharedPreferences loginPreferences;
    Dialog level_finished;
    public int score =0;
    public int a;
    public int i;
    public int[] Array= new int[4];
    public int count=0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_task_two );

        Toolbar toolbar=findViewById(R.id.main_toolbar);
        TextView toolbarTitle=findViewById(R.id.titleText);

        toolbar.setTitle(" ");
        toolbarTitle.setText("Home/Tasks/Task2");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        level_finished = new Dialog(this);

        db=new DatabaseHelper(this);

        loginPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        ImageView = (ImageView) findViewById ( R.id.imageView );
        ImageView1 = (ImageView) findViewById ( R.id.imageView1 );
        ImageView2 = (ImageView) findViewById ( R.id.imageView2 );
        ImageView3 = (ImageView) findViewById ( R.id.imageView3 );
        TextView = (TextView) findViewById ( R.id.fact );
        Button = (Button) findViewById ( R.id.factButton );
        textViewScore = (TextView)findViewById ( R.id.textViewScore ) ;

        ImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView1.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView2.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView3.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        showRandomFact ();

        Button.setOnClickListener ( new View.OnClickListener () {
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

                showRandomFact ();
            }
        } );
        new SweetAlertDialog(this)
                .setTitleText("Choose the correct picture of the given word")
                .setConfirmButtonBackgroundColor(Color.parseColor("#49ACD5"))
                .show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showRandomFact(){
        shuffleFacts ();
        ImageView.setImageResource ( factArray[0].getmImage () );
        ImageView1.setImageResource ( factArray[1].getmImage () );
        ImageView2.setImageResource ( factArray[2].getmImage () );
        ImageView3.setImageResource ( factArray[3].getmImage () );

        ImageView.setTooltipText ( factArray[0].getmFact () );
        ImageView1.setTooltipText ( factArray[1].getmFact () );
        ImageView2.setTooltipText ( factArray[2].getmFact () );
        ImageView3.setTooltipText ( factArray[3].getmFact () );

        count+=1;
        for (int i=0; i<Array.length; i++){
            Array[i] = (int) (Math.random ()*4);
        }
        for (int i=0; i<Array.length; i++){
            a = Array[i];
            TextView.setText ( factArray[a].getmFact () );
        }

    }

    public class Facts {

        private int mImage;
        private String mFact;

        public Facts(int mImage ,String mFact) {
            this.mImage = mImage;
            this.mFact = mFact;
        }

        public int getmImage() {
            return mImage;
        }

        public String getmFact() {
            return mFact;
        }
    }

    Facts f01 = new Facts ( R.raw.annamunna, "அன்னமுன்னா பழம்" );
    Facts f02 = new Facts ( R.raw.apple, "ஆப்பிள் பழம்" );
    Facts f03 = new Facts ( R.raw.april, "சித்திரை மாதம்" );
    Facts f04 = new Facts ( R.raw.august, "ஆவணி மாதம்" );
    Facts f05 = new Facts ( R.raw.banana, "வாழைப்பழம்" );
    Facts f06 = new Facts ( R.raw.black, "கறுப்புநிறம்" );
    Facts f07 = new Facts ( R.raw.blue, "நீலநிறம்" );
    Facts f09 = new Facts ( R.raw.brown, "மண்ணிறம்" );
    Facts f010 = new Facts ( R.raw.december, "மார்கழிமாதம்" );
    Facts f012 = new Facts ( R.raw.febuary, "மாசிமாதம்" );
    Facts f013 = new Facts ( R.raw.friday, "வெள்ளிக்கிழமை" );
    Facts f016 = new Facts ( R.raw.grapes, "திராட்சைப்பழம்" );
    Facts f017 = new Facts ( R.raw.gray, "சாம்பல்நிறம்" );
    Facts f018 = new Facts ( R.raw.green, "பச்சைநிறம்" );
    Facts f019 = new Facts ( R.raw.jack, "பலாப்பழம்" );
    Facts f020 = new Facts ( R.raw.january, "தைமாதம்" );
    Facts f021 = new Facts ( R.raw.july, "ஆடிமாதம்" );
    Facts f023 = new Facts ( R.raw.mango, "மாம்பழம்" );
    Facts f024 = new Facts ( R.raw.march, "பங்குனிமாதம்" );
    Facts f025 = new Facts ( R.raw.mathulai, "மாதுளம்பழம்" );
    Facts f026 = new Facts ( R.raw.may, "வைகாசிமாதம்" );
    Facts f027 = new Facts ( R.raw.monday, "திங்கட்கிழமை" );
    Facts f029 = new Facts ( R.raw.november, "கார்த்திகைமாதம்" );
    Facts f030 = new Facts ( R.raw.october, "ஐப்பசிமாதம்" );
    Facts f031 = new Facts ( R.raw.orange, "செம்மஞ்சள்நிறம்" );
    Facts f032 = new Facts ( R.raw.orange1, "ஆரஞ்சு பழம்" );
    Facts f035 = new Facts ( R.raw.pineapple, "அன்னாசிப்பழம்" );
    Facts f036 = new Facts ( R.raw.pink, "இளம்சிவப்புநிறம்" );
    Facts f037 = new Facts ( R.raw.purple, "ஊதாநிறம்" );
    Facts f038 = new Facts ( R.raw.red, "சிவப்புநிறம்" );
    Facts f039 = new Facts ( R.raw.saturday, "சனிக்கிழமை" );
    Facts f040 = new Facts ( R.raw.septemper, "புரட்டாதிமாதம்" );
    Facts f044 = new Facts ( R.raw.strawberry, "ஸ்ட்ராவ்பெரிப்பழம்" );
    Facts f045 = new Facts ( R.raw.sunday, "ஞாயிறுக்கிழமை" );
    Facts f046 = new Facts ( R.raw.thursday, "வியாழக்கிழமை" );
    Facts f047 = new Facts ( R.raw.tuesday, "செவ்வாய்க்கிழமை" );
    Facts f049 = new Facts ( R.raw.watermelon, "தர்பூசணி" );
    Facts f050 = new Facts ( R.raw.wednesday, "புதன்கிழமை" );
    Facts f051 = new Facts ( R.raw.wood, "விளாம்பழம்" );
    Facts f052 = new Facts ( R.raw.yellow, "மஞ்சள்நிறம்" );

    Facts[] factArray = new Facts[]{
            f01,f02,f03,f04,f05,f06,f07,f09,f010,
            f012,f013,f016,f017,f018,f019,f020,
            f021,f023,f024,f025,f026,f027,f029,f030,
            f031,f032,f035,f036,f037,f038,f039,f040,
            f044,f045,f046,f047,f049,f050,
            f051,f052
    };



    public void shuffleFacts(){
        Collections.shuffle ( Arrays.asList ( factArray ) );
    }

    public void showSuccessMessage() {
        TextView Congra,level;
        Button btnclk;

        Congra = findViewById(R.id.congrats);



        btnclk = (Button)findViewById(R.id.button4);

        level_finished.setContentView(R.layout.level_finished2);
        level_finished.show();




    }
    public void showUncompletedMessage() {


        level_finished.setContentView(R.layout.level_uncompleted2);
        level_finished.show();




    }
    public void updatescore(int score) {

        String id =loginPreferences.getString("userid","");
        Cursor cursor=  db.viewScore(id);
        StringBuilder stringBuilder=new StringBuilder();
        final String[] arr2= new String[400];
        int i=0;

        while(cursor.moveToNext()){
            //   stringBuilder.append(cursor.getString(2));

            arr2[i] = cursor.getString(1);
            i= i+1;

        }

        if (arr2[0] == null) {

            boolean chkinserted = db.insertScore2(score,id);



        } else {

            boolean chkupdated = db.updateScore2(score,id);
        }

        Toast.makeText(getApplicationContext(),"updated "+ id+" "+ arr2[0] +" "+score,Toast.LENGTH_SHORT).show();



    }
    public void toTaskThree(View view) {
        startActivity(new Intent(this, QuizActivity.class));
    }
    public void toTaskTwo(View view) {
        startActivity(new Intent(this, TaskTwo.class));
    }


}
