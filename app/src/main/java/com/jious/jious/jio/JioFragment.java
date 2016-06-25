package com.jious.jious.jio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jious.jious.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BAOJUN on 23/6/16.
 */
public class JioFragment extends Fragment {

    private CircleImageView buttonJio;
    private CircleImageView buttonParty;
    private CircleImageView buttonQuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jio, container, false);

        buttonJio = (CircleImageView) rootView.findViewById(R.id.button_jio);
        buttonParty = (CircleImageView) rootView.findViewById(R.id.button_party);
        buttonQuest = (CircleImageView) rootView.findViewById(R.id.button_quest);

        buttonJio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JioActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
