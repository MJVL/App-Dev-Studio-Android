package mjvl.github.io.libraryloginsql.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mjvl.github.io.libraryloginsql.R;
import mjvl.github.io.libraryloginsql.helper.InputValidation;
import mjvl.github.io.libraryloginsql.model.User;
import mjvl.github.io.libraryloginsql.sql.DatabaseHelper;

/**
 * Created by micha on 11/12/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private Button btnRegister;
    private TextView lblLogin;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        lblLogin = (TextView) findViewById(R.id.lblLogin);

        btnRegister.setOnClickListener(this);
        lblLogin.setOnClickListener(this);

        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegister:
                postDataToSQLite();
                break;
            case R.id.lblLogin:
                finish();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(txtName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(txtEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(txtEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(txtPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(txtPassword, txtConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }
        if (!databaseHelper.checkUser(txtEmail.getText().toString().trim())) {
            user.setName(txtName.getText().toString().trim());
            user.setEmail(txtEmail.getText().toString().trim());
            user.setPassword(txtPassword.getText().toString().trim());
            databaseHelper.addUser(user);
            databaseHelper.addUser(user);
            Toast.makeText(getApplicationContext(), getString(R.string.success_message),
                    Toast.LENGTH_SHORT).show();
            txtName.setText(null);
            txtPassword.setText(null);
            txtEmail.setText(null);
            txtConfirmPassword.setText(null);
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.error_email_exists),
                    Toast.LENGTH_SHORT).show();
        }
    }

}
