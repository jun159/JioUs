package com.jious.jious.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jious.jious.R;
import com.jious.jious.avatar.AvatarActivity;
import com.jious.jious.database.DatabaseUser;
import com.jious.jious.objects.User;

/**
 * RegisterActivity registers user and save in database.
 */
public class RegisterActivity extends Activity {

    private EditText editUserName;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editRetypePassword;
//    private EditText editBlock;
//    private EditText editUnit;
//    private EditText editStreet;
    private EditText editPostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        setRegisterButton();
        setLoginButton();
    }

    private void init() {
        editUserName = (EditText) findViewById(R.id.username);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);
        editRetypePassword = (EditText) findViewById(R.id.retype_password);
//        editBlock = (EditText) findViewById(R.id.address_block);
//        editUnit = (EditText) findViewById(R.id.address_unit);
//        editStreet = (EditText) findViewById(R.id.address_street);
        editPostal = (EditText) findViewById(R.id.address_postal);
        editUserName.setText("James");
        editEmail.setText("james@gmail.com");
        editPassword.setText("james");
        editRetypePassword.setText("james");
        editPostal.setText("677890");
    }

    private void setRegisterButton() {
        Button editRegisterButton = (Button) findViewById(R.id.register_button);
        editRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void setLoginButton() {
        TextView editLoginButton = (TextView) findViewById(R.id.login_button);
        editLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(RegisterActivity.this, AvatarActivity.class);
                RegisterActivity.this.startActivity(mainIntent);
                RegisterActivity.this.finish();
            }
        });
    }

    private void saveData() {
        String username = editUserName.getText().toString();
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        String retypePassword = editRetypePassword.getText().toString();
//        String block = editBlock.getText().toString();
//        String unit = editUnit.getText().toString();
//        String street = editStreet.getText().toString();
        String postal = editPostal.getText().toString();

        setErrorMessage(editUserName, username);
        setErrorMessage(editEmail, email);
        setErrorMessage(editPassword, password);
        setErrorMessage(editRetypePassword, retypePassword);
        setErrorMessage(editPostal, postal);

        if (!password.isEmpty() && password.equals(retypePassword)) {
            User user = new User(username, email, password, postal);
            DatabaseUser databaseUser = new DatabaseUser(this);
            databaseUser.createUser(user);
            startActivity();
        } else {
            editPassword.setError("Passwords do not match");
            editRetypePassword.setError("Passwords do not match");
        }
    }

    private void setErrorMessage(EditText editText, String text) {
        if(text.isEmpty()) {
            editText.setError("This field is required");
        }
    }

    private void startActivity() {
        Intent intent = new Intent(RegisterActivity.this, AvatarActivity.class);
        startActivity(intent);
        finish();
    }
}
