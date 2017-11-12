package mjvl.github.io.libraryloginsql.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mjvl.github.io.libraryloginsql.R;
import mjvl.github.io.libraryloginsql.helper.InputValidation;
import mjvl.github.io.libraryloginsql.sql.DatabaseHelper;

/**
 * Created by micha on 11/12/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View v){

    }

}
