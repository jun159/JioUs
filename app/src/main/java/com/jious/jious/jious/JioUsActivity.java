package com.jious.jious.jious;

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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jious.jious.R;
import com.jious.jious.activity.EventActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class JioUsActivity extends AppCompatActivity {

    private static final SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private static final SimpleDateFormat TIMEFORMATTER = new SimpleDateFormat("hh:mma", Locale.getDefault());

    private TextView textCategory;
    private TextView textActivity;
    private TextView textLocation;
    private TextView textDateFrom;
    private TextView textDateTo;
    private Button buttonMatch;
    private ProgressDialog progressDialog;
    private Calendar calendar = Calendar.getInstance();

    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jious);
        // Display back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textCategory = (TextView) findViewById(R.id.text_category);
        textActivity = (TextView) findViewById(R.id.text_activity);
        textLocation = (TextView) findViewById(R.id.text_location);
        textDateFrom = (TextView) findViewById(R.id.text_dateFrom);
        textDateTo = (TextView) findViewById(R.id.text_dateTo);
        buttonMatch = (Button) findViewById(R.id.button_match);

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

        textLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence options[] = new CharSequence[] {"Ang Mo Kio", "Bedok", "Tampines", "Toa Payoh", "Sembawang"};
                alertDialog(options, "Select location", textLocation);
            }
        });

        textDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker(true, textDateFrom);
                showDateTimePicker(false, textDateFrom);
            }
        });

        textDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker(true, textDateTo);
                showDateTimePicker(false, textDateTo);
            }
        });

        buttonMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(JioUsActivity.this,
                        "Matching", "Please wait...", true, true);
                timerDelayRemoveDialog(progressDialog);
            }
        });
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
                } else {
                    endDate = DATEFORMATTER.format(calendar.getTime());
                }
                String dateTime = "From    " + startDate + ", " + startTime
                        + "\nTo         " + endDate + ", " + endTime;
                textView.setText(dateTime);
                new TimePickerDialog(JioUsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        if(isStart) {
                            startTime = TIMEFORMATTER.format(calendar.getTime()).replaceAll("\\.", "");
                        } else {
                            endTime = TIMEFORMATTER.format(calendar.getTime()).replaceAll("\\.", "");
                        }
                        String dateTime = "From    " + startDate + ", " + startTime
                                + "\nTo         " + endDate + ", " + endTime;
                        textView.setText(dateTime);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }

    public void timerDelayRemoveDialog(final Dialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                d.dismiss();
                Intent intent = new Intent(JioUsActivity.this, EventActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
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
