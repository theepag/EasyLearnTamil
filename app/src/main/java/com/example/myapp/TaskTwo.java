package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class TaskTwo extends AppCompatActivity {

    private ImageView mImageView;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private TextView mTextView;
    private TextView textViewScore;
    private Button mButton;
    public int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_task_two );

        mImageView = (ImageView) findViewById ( R.id.imageView );
        mImageView1 = (ImageView) findViewById ( R.id.imageView1 );
        mImageView2 = (ImageView) findViewById ( R.id.imageView2 );
        mImageView3 = (ImageView) findViewById ( R.id.imageView3 );
        mTextView = (TextView) findViewById ( R.id.fact );
        mButton = (Button) findViewById ( R.id.factButton );
        textViewScore = (TextView)findViewById ( R.id.textViewScore ) ;

        mImageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String input = mImageView1.getImageMatrix ().toString();
                score = score+ 10;
                textViewScore.setText(String.valueOf(score));

                mButton.performClick();


            }
        });

        showRandomFact ();

        mButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                showRandomFact ();
            }
        } );
    }

    public void showRandomFact(){
        shuffleFacts ();
        mImageView.setImageResource ( factArray[0].getmImage () );
        mImageView1.setImageResource ( factArray[2].getmImage () );
        mImageView2.setImageResource ( factArray[1].getmImage () );
        mImageView3.setImageResource ( factArray[3].getmImage () );
        mTextView.setText ( factArray[2].getmFact () );
    }

    Facts f02 = new Facts ( R.raw.apple, "ஆப்பிள் பழம்" );
    Facts f03 = new Facts ( R.raw.april, "சித்திரை மாதம்" );
    Facts f04 = new Facts ( R.raw.august, "ஆவணி மாதம்" );
    Facts f05 = new Facts ( R.raw.banana, "வாழைப்பழம்" );
    Facts f06 = new Facts ( R.raw.black, "கறுப்புநிறம்" );
    Facts f07 = new Facts ( R.raw.blue, "நீலநிறம்" );
    Facts f08 = new Facts ( R.raw.brother, "சகோதரன்" );
    Facts f09 = new Facts ( R.raw.brown, "மண்ணிறம்" );
    Facts f010 = new Facts ( R.raw.december, "மார்கழிமாதம்" );
    Facts f011 = new Facts ( R.raw.father, "அப்பா" );
    Facts f012 = new Facts ( R.raw.febuary, "மாசிமாதம்" );
    Facts f013 = new Facts ( R.raw.friday, "வெள்ளிக்கிழமை" );
    Facts f014 = new Facts ( R.raw.grandfather, "தாத்தா" );
    Facts f015 = new Facts ( R.raw.grandmother, "பாட்டி" );
    Facts f016 = new Facts ( R.raw.grapes, "திராட்சைப்பழம்" );
    Facts f017 = new Facts ( R.raw.gray, "சாம்பல்நிறம்" );
    Facts f018 = new Facts ( R.raw.green, "பச்சைநிறம்" );
    Facts f019 = new Facts ( R.raw.palappalam1, "பலாப்பழம்" );
    Facts f020 = new Facts ( R.raw.january, "தைமாதம்" );
    Facts f021 = new Facts ( R.raw.july, "ஆடிமாதம்" );
    Facts f022 = new Facts ( R.raw.mami, "மாமி" );
    Facts f023 = new Facts ( R.raw.mango, "மாம்பழம்" );
    Facts f024 = new Facts ( R.raw.march, "பங்குனிமாதம்" );
    Facts f026 = new Facts ( R.raw.may, "வைகாசிமாதம்" );
    Facts f027 = new Facts ( R.raw.monday, "திங்கட்கிழமை" );
    Facts f028 = new Facts ( R.raw.mother, "அம்மா" );
    Facts f029 = new Facts ( R.raw.november, "கார்த்திகைமாதம்" );
    Facts f030 = new Facts ( R.raw.october, "ஐப்பசிமாதம்" );
    Facts f031 = new Facts ( R.raw.orange, "செம்மஞ்சள்நிறம்" );
    Facts f032 = new Facts ( R.raw.orange1, "ஆரஞ்சு பழம்" );
    Facts f033 = new Facts ( R.raw.periyamma, "பெரியம்மா" );
    Facts f034 = new Facts ( R.raw.periyappa, "பெரியப்பா" );
    Facts f035 = new Facts ( R.raw.pineapple, "அன்னாசிப்பழம்" );
    Facts f036 = new Facts ( R.raw.pink, "இளம்சிவப்புநிறம்" );
    Facts f037 = new Facts ( R.raw.purple, "ஊதாநிறம்" );
    Facts f038 = new Facts ( R.raw.red, "சிவப்புநிறம்" );
    Facts f039 = new Facts ( R.raw.saturday, "சனிக்கிழமை" );
    Facts f040 = new Facts ( R.raw.septemper, "புரட்டாதிமாதம்" );
    Facts f041 = new Facts ( R.raw.sister, "சகோதரி" );
    Facts f042 = new Facts ( R.raw.sithappa, "சித்தப்பா" );
    Facts f043 = new Facts ( R.raw.siththi, "சித்தி" );
    Facts f045 = new Facts ( R.raw.sunday, "ஞாயிறுக்கிழமை" );
    Facts f046 = new Facts ( R.raw.thursday, "வியாழக்கிழமை" );
    Facts f047 = new Facts ( R.raw.tuesday, "செவ்வாய்க்கிழமை" );
    Facts f048 = new Facts ( R.raw.uncle, "மாமா" );
    Facts f049 = new Facts ( R.raw.watermelon, "தர்பூசணி" );
    Facts f050 = new Facts ( R.raw.wednesday, "புதன்கிழமை" );
    Facts f051 = new Facts ( R.raw.wood, "விளாம்பழம்" );
    Facts f052 = new Facts ( R.raw.yellow, "மஞ்சள்நிறம்" );

    Facts[] factArray = new Facts[]{
            f02,f03,f04,f05,f06,f07,f08,f09,f010,
            f011,f012,f013,f014,f015,f016,f017,f018,f019,f020,
            f021,f022,f023,f024,f026,f027,f028,f029,f030,
            f031,f032,f033,f034,f035,f036,f037,f038,f039,f040,
            f041,f042,f043,f045,f046,f047,f048,f049,f050,
            f051,f052
    };

    public void shuffleFacts(){
        Collections.shuffle ( Arrays.asList ( factArray ) );
    }
}
