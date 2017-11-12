package com.example.micha.libraryloginrevised;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        final TextView lblWelcome = (TextView) findViewById(R.id.lblWelcome);
    }
}
