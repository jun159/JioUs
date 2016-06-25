package com.jious.jious.badgebook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jious.jious.R;
import com.jious.jious.latestactivity.LatestAdapter;
import com.jious.jious.objects.Event;

import java.util.List;

/**
 * Created by BAOJUN on 26/6/16.
 */
public class BadgebookFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_badgebook, container, false);

        return rootView;
    }
}
