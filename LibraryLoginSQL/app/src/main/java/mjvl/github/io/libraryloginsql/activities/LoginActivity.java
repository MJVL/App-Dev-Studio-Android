package mjvl.github.io.libraryloginsql.activities;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mjvl.github.io.libraryloginsql.R;
import mjvl.github.io.libraryloginsql.helper.InputValidation;
import mjvl.github.io.libraryloginsql.sql.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity Activity = LoginActivity.this;
    private NestedScrollView nestedScrollView;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView lblRegister;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        lblRegister = (TextView) findViewById(R.id.lblRegister);

        btnLogin.setOnClickListener(this);
        lblRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                verifyFromSQLite();
                break;
            case R.id.lblRegister:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void verifyFromSQLite(){
        if (!inputValidation.isInputEditTextFilled(txtEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(txtEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(txtPassword, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(txtEmail.getText().toString().trim(), txtPassword.getText().toString().trim())) {
//            Intent accountsIntent = new Intent(activity, UsersActivity.class);
//            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
//            emptyInputEditText();
//            startActivity(accountsIntent);
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.error_valid_email_password),
                    Toast.LENGTH_SHORT).show();
        }
    }

}
