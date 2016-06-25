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
import com.jious.jious.jionow.JioNowActivity;
import com.jious.jious.jious.JioUsActivity;
import com.jious.jious.objects.Event;
import com.jious.jious.quest.QuestActivity;

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
                Intent intent = new Intent(getActivity(), JioNowActivity.class);
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
                Intent intent = new Intent(getActivity(), QuestActivity.class);
                getActivity().startActivity(intent);
            }
        });

        List<Event> eventList = getEventList();
        listView = (ListView) rootView.findViewById(android.R.id.list);
        adapter = new LatestAdapter(getActivity(), R.layout.activity_list_latest, eventList, false);
        listView.setAdapter(adapter);

        return rootView;
    }

    private List<Event> getEventList() {
        List<Event> events = new ArrayList<>();

        Log.d("lol", "here");

        events.add(new Event(R.drawable.justin, "TOA PAYOH SOCCER TEAM", "Bishan Park Sec Sch", "1.6km away", " 27 Jun 2016, Monday, 7:00pm",
                "Justin Wong", 8, 12, 1, 1, false));
        events.add(new Event(R.drawable.profile_hdb, "TENNIS MASTER MATCH", "Bedok Tennis Court", "16.9km away", " 28 Jun 2016, Monday, 10:00am",
                "Michelle Ng", 8, 12, 2, 2, false));
        events.add(new Event(R.drawable.profile_kind, "STORYBOOK READING - FINDING DORY ", "TPY Central Libaray", "0.8km away", " 28 Jun 2016, Monday , 5:00pm",
                "Andrew Lim", 8, 12, 4, 2, false));
        events.add(new Event(R.drawable.profile_1, "TPY CC GATHERING", "SAFRA TPY", "1.6km away", " 29 Jun 2016, Tuesday, 5:00pm",
                "Chin Chong", 8, 12, 7, 3, false));
        events.add(new Event(R.drawable.justin, "YOGO NIGHT", "SAFRA Osim Room", "1.6km away", " 29 Jun 2016, Tuesday, 6:00pm",
                "James Hang", 8, 12, 2, 3, false));


        return events;
    }
}
