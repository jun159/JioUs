package com.jious.jious.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jious.jious.R;

/**
 * Created by BAOJUN on 23/6/16.
 */
public class MeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_me, container, false);

        return rootView;
    }
}
