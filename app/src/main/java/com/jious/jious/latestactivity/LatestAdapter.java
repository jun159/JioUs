package com.jious.jious.latestactivity;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jious.jious.R;
import com.jious.jious.activity.EventActivity;
import com.jious.jious.objects.Event;

import java.util.List;

/**
 * Created by BAOJUN on 31/5/16.
 */
public class LatestAdapter extends ArrayAdapter<Event> {

    private List<Event> eventList;
    private Context context;

    public LatestAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
        this.context = context;
        this.eventList = objects;
    }

    @Override
    public int getCount() {
        return ((null != eventList) ?
                eventList.size() : 0);
    }

    @Override
    public Event getItem(int position) {
        return ((null != eventList) ?
                eventList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(null == view) {
            view = layoutInflater.inflate(R.layout.list_latest, null);
        }

        final Event event = eventList.get(position);

        if(null != event) {
            final CardView rowLayout = (CardView) view.findViewById(R.id.row_layout);
            final TextView buttonShare = (TextView) view.findViewById(R.id.button_share);
            final TextView buttonLike = (TextView) view.findViewById(R.id.button_like);
            final TextView textLocation = (TextView) view.findViewById(R.id.text_location);
            final TextView textPlayer = (TextView) view.findViewById(R.id.text_player);
            final TextView textDay = (TextView) view.findViewById(R.id.text_days);
            final ImageView imageView = (ImageView) view.findViewById(R.id.image_host);
            final TextView textHost = (TextView) view.findViewById(R.id.text_hostname);

            textLocation.setText(event.getLocation());
            Log.d("lol", event.getLocation());
            textPlayer.setText(String.valueOf(event.getCurrentCount()));
            textDay.setText(String.valueOf(event.getCurrentDay()));
            textHost.setText(event.getHost());

            rowLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EventActivity.class);
                    context.startActivity(intent);
                }
            });

            buttonShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            buttonLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        return view;
    }
}