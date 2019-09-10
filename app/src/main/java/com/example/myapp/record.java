package com.example.myapp;
import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

public class record extends AppCompatActivity {
    Button btnRecord,btnStopRecord,btnPlay,btnStop;
    String pathSave="";
    private TextToSpeech mTTS;
    private EditText mEditText;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private Button mButtonSpeak;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    final int REQUEST_PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_record );

        Toolbar toolbar=findViewById(R.id.main_toolbar);
        TextView toolbarTitle=findViewById(R.id.titleText);

        toolbar.setTitle(" ");
        toolbarTitle.setText("Text to Speech");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mButtonSpeak = findViewById(R.id.button_speak);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(new Locale("ta_LK"));

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        mEditText = findViewById(R.id.edit_text);
        mSeekBarPitch = findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed = findViewById(R.id.seek_bar_speed);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        if(!checkPermissionFromDevice())
            requestPermission();

        btnPlay=(Button) findViewById( R.id.bynPlay );
        btnRecord=(Button) findViewById( R.id.btnStartRecord );
        btnStop=(Button) findViewById( R.id.btnStop );
        btnStopRecord=(Button) findViewById( R.id.btnStopRecord );


        btnRecord.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkPermissionFromDevice())

                {



                    pathSave= Environment.getExternalStorageDirectory()
                            .getAbsolutePath()+"/"
                            + UUID.randomUUID().toString()+"_audio_record.3gp";
                    setupMediaRecorder();
                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    btnPlay.setEnabled( false );
                    btnStop.setEnabled( false );

                    Toast.makeText( record.this,"Recording....",Toast.LENGTH_LONG ).show();
                }
                else{
                    requestPermission();
                }
            }
        } );

        btnStopRecord.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                btnStopRecord.setEnabled( false );
                btnPlay.setEnabled( true );
                btnRecord.setEnabled( true );
                btnStop.setEnabled( false );
            }
        } );

        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStop.setEnabled( true );
                btnStopRecord.setEnabled( false );
                btnRecord.setEnabled( false );

                mediaPlayer=new MediaPlayer();
                try{
                    mediaPlayer.setDataSource( pathSave );
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
                Toast.makeText( record.this,"Playing...",Toast.LENGTH_LONG ).show();

            }
        } );

        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStopRecord.setEnabled( false );
                btnRecord.setEnabled( true );
                btnStop.setEnabled( false );
                btnPlay.setEnabled( true );

                if(mediaPlayer !=null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    setupMediaRecorder();
                }
            }
        } );


    }

    private void setupMediaRecorder() {
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource( MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat( MediaRecorder.OutputFormat.THREE_GPP );
        mediaRecorder.setAudioEncoder( MediaRecorder.OutputFormat.AMR_NB );
        mediaRecorder.setOutputFile( pathSave );
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions( this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        },REQUEST_PERMISSION_CODE );
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
        switch (requestCode){
            case REQUEST_PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
                    Toast.makeText( this,"Permission Granted",Toast.LENGTH_LONG ).show();
                else
                    Toast.makeText( this,"Permission Denied",Toast.LENGTH_LONG ).show();
            }
            break;
        }
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_result= ContextCompat.checkSelfPermission( this, Manifest.permission.WRITE_EXTERNAL_STORAGE );
        int record_audio_result=ContextCompat.checkSelfPermission( this,Manifest.permission.RECORD_AUDIO );
        return write_external_storage_result== PackageManager.PERMISSION_GRANTED &&
                record_audio_result==PackageManager.PERMISSION_GRANTED;
    }

    private void speak() {
        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}