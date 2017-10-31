package com.example.mjvl.librarylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    private EditText txtFirstNameC, txtLastNameC, txtStudentIDC;
    private Button btnCreateC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        btnCreateC = (Button)findViewById(R.id.btnCreateC);
        btnCreateC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
        txtFirstNameC = (EditText)findViewById(R.id.txtFirstNameC);
        txtLastNameC = (EditText)findViewById(R.id.txtLastNameC);
        txtStudentIDC = (EditText)findViewById(R.id.txtStudentIDC);
    }

    public void sendMessage(View view) {
        Intent myIntent = new Intent(this, LoginActivity.class);
        /*
        myIntent.putExtra("FNAME",txtFirstNameC.getText().toString());
        myIntent.putExtra("LNAME",txtLastNameC.getText().toString());
        myIntent.putExtra("STUDENTID",Integer.parseInt(txtStudentIDC.getText().toString()));
        */
        startActivity(myIntent);
    }


}
