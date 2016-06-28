package com.jious.jious.attendance;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jious.jious.R;
import com.jious.jious.authentication.PostalActivity;
import com.jious.jious.profile.ProfileActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BAOJUN on 26/6/16.
 */
public class AttendanceActivity extends AppCompatActivity {

    private LinearLayout layout;
    private CircleImageView imageMe;
    private Button buttonCheck;
    private CircleImageView imageView;
    private boolean isBumped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        // Display back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        layout = (LinearLayout) findViewById(R.id.layout_front);
        buttonCheck = (Button) findViewById(R.id.button_checkin);
        imageView = (CircleImageView) findViewById(R.id.image);
        imageMe = (CircleImageView) findViewById(R.id.imageme);

        imageMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        layout.bringToFront();
        layout.setVisibility(View.GONE);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                Animation fadein = AnimationUtils.loadAnimation(AttendanceActivity.this, R.anim.anim_fadein);
                layout.startAnimation(fadein);
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBumped) {
                    layout.setVisibility(View.GONE);
                    Animation fadein = AnimationUtils.loadAnimation(AttendanceActivity.this, R.anim.anim_fadeout);
                    layout.startAnimation(fadein);
                    imageView.setBorderColor(getResources().getColor(R.color.green_light));
                } else {
                    ProgressDialog progressDialog = ProgressDialog.show(AttendanceActivity.this,
                            "Saving attendance", "Please wait...", true, true);
                    timerDelayRemoveDialog(progressDialog);
                }
            }
        });
    }

    public void timerDelayRemoveDialog(final Dialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                d.dismiss();
                alertDialog("Attendance", "Attendance saved successfully");
            }
        }, 800);
    }

    private void alertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_check_circle_black_24dp);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                isBumped = true;
                dialog.cancel();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
