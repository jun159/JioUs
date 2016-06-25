package com.jious.jious.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.jious.jious.R;
import com.jious.jious.jionow.JioNowActivity;
import com.jious.jious.jious.JioUsActivity;
import com.jious.jious.latestactivity.LatestAdapter;
import com.jious.jious.objects.Event;
import com.jious.jious.quest.QuestActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class AttendanceFragment extends Fragment {

    private ListView listView;
    private LatestAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_latest, container, false);
        List<Event> eventList = getEventList();
        listView = (ListView) rootView.findViewById(android.R.id.list);
        adapter = new LatestAdapter(getActivity(), R.layout.activity_list_latest, eventList, true);
        listView.setAdapter(adapter);

        return rootView;
    }

    private List<Event> getEventList() {
        List<Event> events = new ArrayList<>();

        Log.d("lol", "here");

        events.add(new Event(R.drawable.justin, "TOA PAYOH SOCCER TEAM", "BISHAN PARK SEC SCH", "3.2km", " 26 Jun 2016, Sunday, 6:00pm",
                "James Lee", 8, 12, 1, 1, false));
        events.add(new Event(R.drawable.profile_1, "SPRING FIELD MATCH", "SAFRA TPY", "1.3km", " 29 Jun 2016, Tuesday, 7:00pm",
                "Tom Tan", 8, 12, 2, 3, false));


        return events;
    }
}
