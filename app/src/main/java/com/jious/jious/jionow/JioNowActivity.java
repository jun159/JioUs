package com.jious.jious.jionow;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jious.jious.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class JioNowActivity extends AppCompatActivity {

    private static final SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private static final SimpleDateFormat TIMEFORMATTER = new SimpleDateFormat("hh:mma", Locale.getDefault());

    private TextView textCategory;
    private TextView textActivity;
    private TextView textDate;
    private TextView textJioDate;
    private TextView textMin;
    private TextView textMax;
    private Button buttonCreate;
    private Calendar calendar = Calendar.getInstance();

    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jionow);
        // Display back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textCategory = (TextView) findViewById(R.id.text_category);
        textActivity = (TextView) findViewById(R.id.text_activity);
        textDate = (TextView) findViewById(R.id.text_dateTime);
        textJioDate = (TextView) findViewById(R.id.text_jiodate);
        textMin = (TextView) findViewById(R.id.text_min);
        textMax = (TextView) findViewById(R.id.text_max);
        buttonCreate = (Button) findViewById(R.id.button_create);

        textCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence options[] = new CharSequence[] {"Sports", "Bla A", "Bla B"};
                alertDialog(options, "Select Category", textCategory);
            }
        });

        textActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence options[] = new CharSequence[] {"Badminton", "Soccer", "Tennis"};
                alertDialog(options, "Select Activity", textActivity);
            }
        });

        textMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertNumberPicker("Select Min Pax", textMin);
            }
        });

        textMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertNumberPicker("Select Max Pax", textMax);
            }
        });

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker(true, textDate);
            }
        });

        textJioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker(true, textJioDate);
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JioNowActivity.this, ActivesgActivity.class);
                startActivity(intent);
            }
        });
    }

    private void alertNumberPicker(String title, final TextView textView) {
        RelativeLayout linearLayout = new RelativeLayout(JioNowActivity.this);
        final NumberPicker aNumberPicker = new NumberPicker(JioNowActivity.this);
        aNumberPicker.setMaxValue(100);
        aNumberPicker.setMinValue(1);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
        RelativeLayout.LayoutParams numPicerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        numPicerParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        linearLayout.setLayoutParams(params);
        linearLayout.addView(aNumberPicker,numPicerParams);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(JioNowActivity.this);
        alertDialogBuilder.setTitle("Select Min Pax");
        alertDialogBuilder.setView(linearLayout);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                textView.setText(id);
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void showDateTimePicker(final boolean isStart, final TextView textView) {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);
                calendar.set(year, monthOfYear, dayOfMonth);
                if(isStart) {
                    startDate = DATEFORMATTER.format(calendar.getTime());
                    textView.setText(startDate);
                } else {
                    endDate = DATEFORMATTER.format(calendar.getTime());
                    textView.setText(endDate);
                }
                new TimePickerDialog(JioNowActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        if(isStart) {
                            startTime = TIMEFORMATTER.format(calendar.getTime()).replaceAll("\\.", "");
                            textView.setText(startDate + ", " + startTime);
                        } else {
                            endTime = TIMEFORMATTER.format(calendar.getTime()).replaceAll("\\.", "");
                            textView.setText(endDate + ", " + endTime);
                        }
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }

    private void alertDialog(final CharSequence[] options, String title, final TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setIcon(R.drawable.ic_);
        builder.setTitle(title);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText(options[which]);
                dialog.dismiss();
            }
        });

        builder.show();
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
