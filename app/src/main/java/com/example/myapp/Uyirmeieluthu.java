package com.example.myapp;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Uyirmeieluthu extends AppCompatActivity {

    MediaPlayer mySong;
    DatabaseHelper myDB;
    private PaintView paintView;
    private PaintView canvasView;
    private Button button;

    private static final int[] idArry = {R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15,R.id.b16,R.id.b17,R.id.b18};
    private Button[] button1 = new  Button[idArry.length];
    int i;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyirmeieluthu);

        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        canvasView = (PaintView) findViewById ( R.id.paintView );

        myDB = new DatabaseHelper(this);

        button = (Button) findViewById ( R.id.button );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                clearCanvas ();
            }
        } );

        for (i=0; i<idArry.length; i++){

            button1[i] = (Button)findViewById ( idArry[i] );

            button1[i].setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    TextView textView = findViewById ( R.id.textView );

                    switch (v.getId ()){
                        case R.id.b1:
                            Cursor cursor1 = myDB.ViewData31 ();
                            StringBuilder stringBuilder1 = new StringBuilder (  );

                            while (cursor1.moveToNext ()){
                                stringBuilder1.append ( cursor1.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder1 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.ka);
                            button.performClick ();
                            break;

                        case R.id.b2:
                            Cursor cursor2 = myDB.ViewData32 ();
                            StringBuilder stringBuilder2 = new StringBuilder (  );

                            while (cursor2.moveToNext ()){
                                stringBuilder2.append ( cursor2.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder2 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.nja);
                            button.performClick ();
                            break;

                        case R.id.b3:
                            Cursor cursor3 = myDB.ViewData33 ();
                            StringBuilder stringBuilder3 = new StringBuilder (  );

                            while (cursor3.moveToNext ()){
                                stringBuilder3.append ( cursor3.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder3 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.cha);
                            button.performClick ();
                            break;

                        case R.id.b4:
                            Cursor cursor4 = myDB.ViewData34 ();
                            StringBuilder stringBuilder4 = new StringBuilder (  );

                            while (cursor4.moveToNext ()){
                                stringBuilder4.append ( cursor4.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder4 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.jea);
                            button.performClick ();
                            break;

                        case R.id.b5:
                            Cursor cursor5 = myDB.ViewData35 ();
                            StringBuilder stringBuilder5 = new StringBuilder (  );

                            while (cursor5.moveToNext ()){
                                stringBuilder5.append ( cursor5.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder5 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.da);
                            button.performClick ();
                            break;

                        case R.id.b6:
                            Cursor cursor6 = myDB.ViewData36 ();
                            StringBuilder stringBuilder6 = new StringBuilder (  );

                            while (cursor6.moveToNext ()){
                                stringBuilder6.append ( cursor6.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder6 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.naana);
                            button.performClick ();
                            break;

                        case R.id.b7:
                            Cursor cursor7 = myDB.ViewData37 ();
                            StringBuilder stringBuilder7 = new StringBuilder (  );

                            while (cursor7.moveToNext ()){
                                stringBuilder7.append ( cursor7.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder7 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.tha);
                            button.performClick ();
                            break;

                        case R.id.b8:
                            Cursor cursor8 = myDB.ViewData38 ();
                            StringBuilder stringBuilder8 = new StringBuilder (  );

                            while (cursor8.moveToNext ()){
                                stringBuilder8.append ( cursor8.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder8 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.nana);
                            button.performClick ();
                            break;

                        case R.id.b9:
                            Cursor cursor9 = myDB.ViewData39 ();
                            StringBuilder stringBuilder9 = new StringBuilder (  );

                            while (cursor9.moveToNext ()){
                                stringBuilder9.append ( cursor9.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder9 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.pa);
                            button.performClick ();
                            break;

                        case R.id.b10:
                            Cursor cursor10 = myDB.ViewData310 ();
                            StringBuilder stringBuilder10 = new StringBuilder (  );

                            while (cursor10.moveToNext ()){
                                stringBuilder10.append ( cursor10.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder10 );
                            mySong=MediaPlayer.create(Uyirmeieluthu.this,R.raw.ma);
                            button.performClick ();
                            break;

                        case R.id.b11:
                            Cursor cursor11 = myDB.ViewData311 ();
                            StringBuilder stringBuilder11 = new StringBuilder (  );

                            while (cursor11.moveToNext ()){
                                stringBuilder11.append ( cursor11.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder11 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this,R.raw.ja);
                            button.performClick ();
                            break;

                        case R.id.b12:
                            Cursor cursor12 = myDB.ViewData312 ();
                            StringBuilder stringBuilder12 = new StringBuilder (  );

                            while (cursor12.moveToNext ()){
                                stringBuilder12.append ( cursor12.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder12 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.ta);
                            button.performClick ();
                            break;

                        case R.id.b13:
                            Cursor cursor13 = myDB.ViewData313 ();
                            StringBuilder stringBuilder13 = new StringBuilder (  );

                            while (cursor13.moveToNext ()){
                                stringBuilder13.append ( cursor13.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder13 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.la);
                            button.performClick ();
                            break;

                        case R.id.b14:
                            Cursor cursor14 = myDB.ViewData314 ();
                            StringBuilder stringBuilder14 = new StringBuilder (  );

                            while (cursor14.moveToNext ()){
                                stringBuilder14.append ( cursor14.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder14 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.va);
                            button.performClick ();
                            break;

                        case R.id.b15:
                            Cursor cursor15 = myDB.ViewData315 ();
                            StringBuilder stringBuilder15 = new StringBuilder (  );

                            while (cursor15.moveToNext ()){
                                stringBuilder15.append ( cursor15.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder15 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.lala);
                            button.performClick ();
                            break;

                        case R.id.b16:
                            Cursor cursor16 = myDB.ViewData316 ();
                            StringBuilder stringBuilder16 = new StringBuilder (  );

                            while (cursor16.moveToNext ()){
                                stringBuilder16.append ( cursor16.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder16 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.lalala);
                            button.performClick ();
                            break;

                        case R.id.b17:
                            Cursor cursor17 = myDB.ViewData317 ();
                            StringBuilder stringBuilder17 = new StringBuilder (  );

                            while (cursor17.moveToNext ()){
                                stringBuilder17.append ( cursor17.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder17 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.rara);
                            button.performClick ();
                            break;

                        case R.id.b18:
                            Cursor cursor18 = myDB.ViewData318 ();
                            StringBuilder stringBuilder18 = new StringBuilder (  );

                            while (cursor18.moveToNext ()){
                                stringBuilder18.append ( cursor18.getString ( 1 ) );
                            }
                            textView.setText ( stringBuilder18 );
                            mySong= MediaPlayer.create(Uyirmeieluthu.this, R.raw.nnana);
                            button.performClick ();
                            break;
                    }
                }
            } );
        }

    }

    public void clearCanvas() {
        canvasView.clearCanvas ();
    }

    public void playIT(View v) {
        mySong.start();
    }
}