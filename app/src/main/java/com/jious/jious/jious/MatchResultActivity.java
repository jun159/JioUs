package com.jious.jious.jious;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jious.jious.R;
import com.jious.jious.latestactivity.LatestAdapter;
import com.jious.jious.objects.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class MatchResultActivity extends AppCompatActivity {

    private ListView listView;
    private LatestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_latest);
        // Display back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<Event> eventList = getEventList();
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new LatestAdapter(this, R.layout.activity_list_latest, eventList);
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

        events.add(new Event("TOA PAYOH SOCCER TEAM", "BISHAN PARK SEC SCH     3.2km", " 26 JUN 2016, SUNDAY, 6:00PM",
                "James Lee", 8, 12, 1, 1, false));
        events.add(new Event("SPRING FIELD MATCH", "SAFRA TPY                  1.3km", " 29 JUN 2016, TUESDAY, 7:00PM",
                "Ahmad Sathin", 8, 12, 2, 3, false));
        events.add(new Event("TPY V.S AMK FRIENDS MATCH", "AMK ITE CENTRAL     6.5km ", " 02 JULY 2016, SATURDAY, 9:00AM",
                "Lawrance Tee", 8, 12, 5, 6, false));
        events.add(new Event("HAPPY TIONG BARU SOCCER", "REDHILL SEC SCH       12km", " 03 July 2016, SUNDAY, 2:00PM",
                "Steve Jobs", 8, 12, 3, 7, false));
        events.add(new Event("TOA PAYOH SOCCER TEAM", "BISHAN PARK SEC SCH     3.2km", " 26 JUN 2016, SUNDAY, 6:00PM",
                "James Lee", 8, 12, 1, 1, false));
        events.add(new Event("SPRING FIELD MATCH", "SAFRA TPY                  1.3km", " 29 JUN 2016, TUESDAY, 7:00PM",
                "Ahmad Sathin", 8, 12, 2, 3, false));
        events.add(new Event("TPY V.S AMK FRIENDS MATCH", "AMK ITE CENTRAL     6.5km ", " 02 JULY 2016, SATURDAY, 9:00AM",
                "Lawrance Tee", 8, 12, 5, 6, false));
        events.add(new Event("HAPPY TIONG BARU SOCCER", "REDHILL SEC SCH       12km", " 03 July 2016, SUNDAY, 2:00PM",
                "Steve Jobs", 8, 12, 3, 7, false));

        return events;
    }
}
