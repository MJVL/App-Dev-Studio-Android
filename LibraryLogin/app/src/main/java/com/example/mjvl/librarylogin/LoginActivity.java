package com.example.mjvl.librarylogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName, txtStudentID;
    private Button btnLogin, btnSwap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSwap = (Button)findViewById(R.id.btnSwap);
        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
        txtFirstName = (EditText)findViewById(R.id.txtFirstNameC);
        txtLastName = (EditText)findViewById(R.id.txtLastNameC);
        txtStudentID = (EditText)findViewById(R.id.txtStudentIDC);
    }

    public void sendMessage(View view) {
        Intent myIntent = new Intent(this, CreateActivity.class);
        startActivity(myIntent);
    }
}

