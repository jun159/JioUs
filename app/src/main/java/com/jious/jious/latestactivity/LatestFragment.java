package com.jious.jious.latestactivity;

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
import com.jious.jious.jio.JioActivity;
import com.jious.jious.jious.JioUsActivity;
import com.jious.jious.objects.Event;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class LatestFragment extends Fragment {

    private LinearLayout layoutFront;
    private ListView listView;
    private LatestAdapter adapter;
    private CircleImageView buttonJio;
    private CircleImageView buttonParty;
    private CircleImageView buttonQuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jio, container, false);

        layoutFront = (LinearLayout) rootView.findViewById(R.id.layout_front);
        buttonJio = (CircleImageView) rootView.findViewById(R.id.button_jio);
        buttonParty = (CircleImageView) rootView.findViewById(R.id.button_party);
        buttonQuest = (CircleImageView) rootView.findViewById(R.id.button_quest);

        layoutFront.bringToFront();
        buttonJio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JioActivity.class);
                getActivity().startActivity(intent);
            }
        });

        buttonParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JioUsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        buttonQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        List<Event> eventList = getEventList();
        listView = (ListView) rootView.findViewById(android.R.id.list);
        adapter = new LatestAdapter(getActivity(), R.layout.activity_list_latest, eventList);
        listView.setAdapter(adapter);

        return rootView;
    }

    private List<Event> getEventList() {
        List<Event> events = new ArrayList<>();

        Log.d("lol", "here");

        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));
        events.add(new Event("TOA PAYOH FOOTBALL TEAM", "SAFRA TPY              1.6km away", " 25 DEC 2016, SUNDAY, 2:00PM",
                "James", 8, 12, 2, 3, false));

        return events;
    }
}
