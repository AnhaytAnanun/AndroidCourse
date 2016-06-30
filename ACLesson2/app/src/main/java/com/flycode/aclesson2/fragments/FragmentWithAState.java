package com.flycode.aclesson2.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.flycode.aclesson2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWithAState extends Fragment {
    private static final String SAVED_INPUT = "savedInput";

    private View fragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_with_a_state, container, false);

        /**
         * Check that savedInstanceState is not null.
         * It will be null if there is no previous fragment state.
         */

        if (savedInstanceState != null) {
            /**
             * Retrieve text for EditText from savedInstanceState bundle
             */

            String savedInput = savedInstanceState.getString(SAVED_INPUT);

            EditText editText = (EditText) fragmentView.findViewById(R.id.input);
            editText.setText(savedInput);
        }

        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /**
         * Put text of EditText into outState bundle
         */

        EditText editText = (EditText) fragmentView.findViewById(R.id.input);
        outState.putString(SAVED_INPUT, editText.getText().toString());
    }
}
