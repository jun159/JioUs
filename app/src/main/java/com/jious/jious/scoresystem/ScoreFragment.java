package com.jious.jious.scoresystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jious.jious.R;

/**
 * Created by BAOJUN on 26/6/16.
 */
public class ScoreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_scoresystem, container, false);

        return rootView;
    }
}
