package mjvl.github.io.libraryloginsql.activities;

/**
 * Created by micha on 11/12/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import mjvl.github.io.libraryloginsql.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lblWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lblWelcome = (TextView) findViewById(R.id.lblWelcome);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        lblWelcome.setText("Welcome " + nameFromIntent);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){

        }
    }
}