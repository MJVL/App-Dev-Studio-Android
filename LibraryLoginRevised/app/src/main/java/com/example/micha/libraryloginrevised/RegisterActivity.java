package com.example.micha.libraryloginrevised;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        final EditText txtUsername = (EditText) findViewById(R.id.txtUserName);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}
