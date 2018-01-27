package com.tradecapital.youssoufdasilva.tradecapitalv01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by youssoufdasilva on 25/01/2018.
 */

public class DashboardFragment extends Fragment {
    private static final String TAG = "DashboardFragment";

    public static final String ARG_TITLE = "arg_title";

    private TextView textView;

    public DashboardFragment() {
        // Apparently required constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard,
                container, false);

        Log.d(TAG, "onCreate: started.");

        textView = rootView.findViewById(R.id.fragment_dashboard_text);

        String title = getArguments().getString(ARG_TITLE, "");
        textView.setText(title + " Tab!");

        return rootView;
    }
}
