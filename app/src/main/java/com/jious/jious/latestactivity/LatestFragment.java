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

        events.add(new Event("TOA PAYOH SOCCER TEAM", "Bishan Park Sec Sch              1.6km away", " 27 JUN 2016, MONDAY, 7:00PM",
                "Justin Wong", 8, 12, 1, 1, false));
        events.add(new Event("TENNIS MASTER MATCH", " Bedok Tennis Court        16.9km away", " 28 JUN 2016, MONDAY, 10:00AM",
                "Michelle Ng", 8, 12, 2, 2, false));
        events.add(new Event("STORYBOOK READING - FINDING DORY ", "TPY Central Libaray     0.8km away", " 28 JUN 2016, MONDAY , 5:00PM",
                "Andrew Lim", 8, 12, 4, 2, false));
        events.add(new Event("TPY CC GATHERING", "SAFRA TPY              1.6km away", " 29 JUN 2016, TUESDAY, 5:00PM",
                "Chin Chong", 8, 12, 7, 3, false));
        events.add(new Event("YOGO NIGHT", "SAFRA OSIM ROOM              1.6km away", " 29 JUN 2016, TUESDAY, 6:00PM",
                "James Hang", 8, 12, 2, 3, false));
        events.add(new Event("HAPPY TABLE - MAHJONG", "NOVENA CC HALL     3.6km away", " 30 JUN 2016, WEDNESDAY, 10:00AM",
                "Jaslyn Yong", 8, 12, 1, 4, false));
        events.add(new Event("TENNIS MASTER MATCH", " Bedok Tennis Court        16.9km away", " 28 JUN 2016, MONDAY, 10:00AM",
                "Michelle Ng", 8, 12, 2, 2, false));
        events.add(new Event("STORYBOOK READING - FINDING DORY ", "TPY Central Libaray     0.8km away", " 28 JUN 2016, MONDAY , 5:00PM",
                "Andrew Lim", 8, 12, 4, 2, false));
        events.add(new Event("TPY CC GATHERING", "SAFRA TPY              1.6km away", " 29 JUN 2016, TUESDAY, 5:00PM",
                "Chin Chong", 8, 12, 7, 3, false));
        events.add(new Event("YOGO NIGHT", "SAFRA OSIM ROOM              1.6km away", " 29 JUN 2016, TUESDAY, 6:00PM",
                "James Hang", 8, 12, 2, 3, false));
        events.add(new Event("HAPPY TABLE - MAHJONG", "NOVENA CC HALL     3.6km away", " 30 JUN 2016, WEDNESDAY, 10:00AM",
                "Jaslyn Yong", 8, 12, 1, 4, false));


        return events;
    }
}
