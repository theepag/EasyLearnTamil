package com.example.myapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Uyirmeieluthu extends AppCompatActivity {

    DatabaseHelper myDB;
    private PaintView paintView;
    private PaintView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_uyirmeieluthu );

        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        canvasView = (PaintView) findViewById ( R.id.paintView );

        myDB = new DatabaseHelper(this);

        Button viewdata11 = (Button) findViewById ( R.id.btn1 );

        viewdata11.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData111 ();
                StringBuilder stringBuilder = new StringBuilder (  );

                while (cursor.moveToNext ()){
                    stringBuilder.append ( cursor.getString ( 1 ) );
                }
                textView.setText ( stringBuilder );
            }
        } );

        Button viewdata22 = (Button) findViewById ( R.id.btn2 );

        viewdata22.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById ( R.id.textView );
                Cursor cursor = myDB.ViewData222 ();
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
