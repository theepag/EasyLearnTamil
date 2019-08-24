package com.example.myapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Meieluthu extends AppCompatActivity {

    DatabaseHelper myDB;
    private PaintView paintView;
    private PaintView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_meieluthu );

        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        canvasView = (PaintView) findViewById ( R.id.paintView );

        myDB = new DatabaseHelper(this);

        Button viewdata11 = (Button) findViewById(R.id.b11);

        viewdata11.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData11 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata22 = (Button) findViewById ( R.id.b22 );

        viewdata22.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData22 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata33 = (Button) findViewById ( R.id.b33 );

        viewdata33.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData33 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata44 = (Button) findViewById ( R.id.b44 );

        viewdata44.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData44 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata55 = (Button) findViewById ( R.id.b55 );

        viewdata55.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData55 ();
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
