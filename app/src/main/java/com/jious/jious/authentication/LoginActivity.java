package com.jious.jious.authentication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jious.jious.R;
import com.jious.jious.database.DatabaseUser;
import com.jious.jious.jio.EventActivity;
import com.jious.jious.main.NavigationActivity;
import com.jious.jious.objects.User;

/**
 * LoginActivity offers login via username/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String KEY_PREF = "loginPrefs";
    private static final String KEY_IS_LOGIN = "saveLogin";
    private static final String KEY_USERNAME = "username";

    public AutoCompleteTextView mUsernameView;
    public EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSignInButton();
        setRegisterButton();
        setUsernameText();
        setPasswordText();
//        setSaveLoginText();
    }

    private void setSignInButton() {
        Button mUsernameSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mUsernameSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void setRegisterButton() {
        TextView registerButton = (TextView) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,
                        "Establishing connection", "Please wait...", true, true);
                timerDelayRemoveDialog(progressDialog);
            }
        });
    }

    public void timerDelayRemoveDialog(final Dialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                d.dismiss();
                Intent intent = new Intent(LoginActivity.this, PostalActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    private void setUsernameText() {
        mUsernameView = (AutoCompleteTextView) findViewById(R.id.email);
        setEditTextLine(mUsernameView);
        mUsernameView.setText("justin");
    }

    private void setPasswordText() {
        mPasswordView = (EditText) findViewById(R.id.password);
        setEditTextLine(mPasswordView);
        mPasswordView.setText("justin");
    }

    private void setEditTextLine(EditText editText) {
        Drawable drawable = editText.getBackground();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        if(Build.VERSION.SDK_INT > 16) {
            editText.setBackground(drawable);
        }else{
            editText.setBackgroundDrawable(drawable);
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid username, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Store values at the time of the login attempt
        reset();
//        String username = mUsernameView.getText().toString();
//        String password = mPasswordView.getText().toString();
//        saveAccount(username);
//        validateUsername(username);
//        validatePassword(username);
//        validateAccount(username, password);
    }

    private void reset() {
        mUsernameView.setError(null);
        mPasswordView.setError(null);
    }

//    private void saveAccount(String username) {
//        loginPrefsEditor.putBoolean(KEY_PREF, true);
//        loginPrefsEditor.putString(KEY_USERNAME, username);
//        loginPrefsEditor.commit();
//    }

//    private void validateUsername(String username) {
//        if (TextUtils.isEmpty(username)) {
//            mUsernameView.setError(getString(R.string.error_field_required));
//            focusView = mUsernameView;
//            cancel = true;
//        }
//    }
//
//    private void validatePassword(String password) {
//        if (TextUtils.isEmpty(password)) {
//            mPasswordView.setError(getString(R.string.error_field_required));
//            focusView = mPasswordView;
//            cancel = true;
//        }
//    }

//    private void validateAccount(String userName, String password) {
//        if(!cancel) {
//            DatabaseUser databaseUser = new DatabaseUser(this);
//            User user = databaseUser.readUser(userName);
//
//            if (user == null || !user.getPassword().equals(password)) {
//                mUsernameView.setError("Incorrect username or password");
//                mPasswordView.setError("Incorrect username or password");
//            } else {
//                Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
//                intent.putExtra("user", user);
//                LoginActivity.this.startActivity(intent);
//                LoginActivity.this.finish();
//            }
//        }
//    }
}