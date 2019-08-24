package com.example.myapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Uyireluthu extends AppCompatActivity {

    DatabaseHelper myDB;
    private PaintView paintView;
    private PaintView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_uyireluthu );

        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        canvasView = (PaintView) findViewById ( R.id.paintView );

        myDB = new DatabaseHelper(this);

        Button viewdata1 = (Button) findViewById(R.id.b1);

        viewdata1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData1 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata2 = (Button) findViewById ( R.id.b2 );

        viewdata2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData2 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata3 = (Button) findViewById ( R.id.b3 );

        viewdata3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData3 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata4 = (Button) findViewById ( R.id.b4 );

        viewdata4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData4 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata5 = (Button) findViewById ( R.id.b5 );

        viewdata5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData5 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );
    }

    public void clearCanvas(View v) {
        canvasView.clearCanvas ();
    }
}
