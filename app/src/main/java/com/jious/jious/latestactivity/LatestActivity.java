package com.jious.jious.latestactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jious.jious.R;
import com.jious.jious.objects.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class LatestActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_event);
        // Display back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<Event> eventList = getEventList();
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new LatestAdapter(this, R.layout.activity_list_event, eventList);
        listView.setAdapter(adapter);
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


    private List<Event> getEventList() {
        List<Event> events = new ArrayList<>();

        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));

        return events;
    }
}
