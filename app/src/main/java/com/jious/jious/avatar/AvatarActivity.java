package com.jious.jious.avatar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jious.jious.R;
import com.jious.jious.authentication.LoginActivity;
import com.jious.jious.main.NavigationActivity;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class AvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        ImageView imageView = (ImageView) findViewById(R.id.button_dress);
        Button buttonStart = (Button) findViewById(R.id.button_start_jio);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvatarActivity.this, DressActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvatarActivity.this, NavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
