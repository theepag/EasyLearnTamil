package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    Button b1;
    DatabaseHelper db;
    TextView textview;
    CheckBox saveLoginCheckBox;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db=new DatabaseHelper(this);
        e1=(EditText) findViewById(R.id.editUsername);
        e2=(EditText) findViewById(R.id.editPassword);
        b1=(Button) findViewById(R.id.btnLogin);
        textview=(TextView) findViewById(R.id.register);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.checkBox);

        loginPreferences = getSharedPreferences("loginPrefs",MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin",true);

        if (saveLogin== true) {
            e1.setText(loginPreferences.getString("username",""));
            e2.setText(loginPreferences.getString("password",""));
            saveLoginCheckBox.setChecked(true);

        }

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=e1.getText().toString();
                String password=e2.getText().toString();
                boolean chklogin=db.userpassword(uname,password);


                if(chklogin==true){

                    if (saveLoginCheckBox.isChecked()) {

                        loginPrefsEditor.putBoolean("saveLogin",true);
                        loginPrefsEditor.putString("username",uname);
                        loginPrefsEditor.putString("password",password);
                        loginPrefsEditor.commit();

                        Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, SelectionActivity.class));
                    } else {

                        loginPrefsEditor.clear();
                        loginPrefsEditor.commit();
                    }

                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, SelectionActivity.class));



                }
                else{
                    Toast.makeText(getApplicationContext(),"Something wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void ToRegister (View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }


}
