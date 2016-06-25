package com.jious.jious.authentication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jious.jious.R;
import com.jious.jious.main.NavigationActivity;

/**
 * Created by BAOJUN on 25/6/16.
 */
public class PostalActivity extends Activity {

    private ImageView imageMap;
    private ImageView imageTpy;
    private Button buttonNext;
    private TextView buttonTown;
    private TextView textTown;
    private EditText editPostal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postal);

        imageMap = (ImageView) findViewById(R.id.image_map);
        imageTpy = (ImageView) findViewById(R.id.image_tpy);
        textTown = (TextView) findViewById(R.id.text_town);
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonTown = (TextView) findViewById(R.id.button_town);
        textTown.setVisibility(View.INVISIBLE);
        imageMap.setVisibility(View.VISIBLE);
        imageTpy.setVisibility(View.GONE);
        editPostal = (EditText) findViewById(R.id.address_postal);
        setEditTextLine(editPostal);

        buttonTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadein = AnimationUtils.loadAnimation(PostalActivity.this, R.anim.anim_fadein);
                imageTpy.startAnimation(fadein);
                imageMap.setVisibility(View.GONE);
                imageTpy.setVisibility(View.VISIBLE);
                editPostal.setText("310123");
                textTown.setVisibility(View.VISIBLE);
                buttonNext.setVisibility(View.VISIBLE);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostalActivity.this, NavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void isDone() {
        imageMap.setVisibility(View.GONE);
        imageTpy.setVisibility(View.VISIBLE);
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
}
