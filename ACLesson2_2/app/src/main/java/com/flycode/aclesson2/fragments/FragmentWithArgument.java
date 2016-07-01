package com.flycode.aclesson2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;

import com.flycode.aclesson2.R;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by anhaytananun on 29.06.16.
 */
public class FragmentWithArgument extends Fragment {
    private static final String USERNAME = "username";
    private static final String DATE = "date";
    private static final String ID = "id";
    private static final String IS_A_GOAT = "isAGoat";

    public static FragmentWithArgument createInstance(String username, Date date, int id, boolean isAGoat) {
        FragmentWithArgument fragmentWithArgument = new FragmentWithArgument();

        Bundle arguments = new Bundle();
        arguments.putString(USERNAME, username);
        arguments.putSerializable(DATE, date);
        arguments.putInt(ID, id);
        arguments.putBoolean(IS_A_GOAT, isAGoat);

        fragmentWithArgument.setArguments(arguments);

        return fragmentWithArgument;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_with_arguments, container, false);

        Bundle arguments = getArguments();

        if (arguments != null) {
            TextView usernameTextView = (TextView) fragmentView.findViewById(R.id.username);
            TextView dateTextView = (TextView) fragmentView.findViewById(R.id.date);
            TextView idTextView = (TextView) fragmentView.findViewById(R.id.id);
            CheckBox checkBox = (CheckBox) fragmentView.findViewById(R.id.is_a_goat);

            usernameTextView.setText(arguments.getString(USERNAME));
            dateTextView.setText(arguments.getSerializable(DATE).toString());
            checkBox.setChecked(arguments.getBoolean(IS_A_GOAT));

            /**
             * Try this without String.valueOf 3:)
             */
            idTextView.setText(String.valueOf(arguments.getInt(ID)));
        }

        return fragmentView;
    }
}
