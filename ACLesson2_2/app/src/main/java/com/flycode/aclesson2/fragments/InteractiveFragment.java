package com.flycode.aclesson2.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.flycode.aclesson2.R;

/**
 * Created by anhaytananun on 29.06.16.
 */
public class InteractiveFragment extends Fragment implements View.OnClickListener {
    private InteractiveFragmentLister listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_interactive, container, false);

        Button redButton = (Button) fragmentView.findViewById(R.id.red);
        Button greenButton = (Button) fragmentView.findViewById(R.id.green);
        Button blueButton = (Button) fragmentView.findViewById(R.id.blue);

        /**
         * We make InteractiveFragment to implement OnClickListener,
         * so now we can make it to listen for button click events
         */

        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        return fragmentView;
    }

    @Override
    public void onClick(View view) {
        /**
         * Check what color was clicked,
         * Check that listener is not null,
         * Call appropriate method
         */
        if (view.getId() == R.id.blue) {
            if (listener != null) {
                listener.onChangeColor(Color.BLUE);
            }
        } else if (view.getId() == R.id.green) {
            if (listener != null) {
                listener.onChangeColor(Color.GREEN);
            }
        } else if (view.getId() == R.id.red) {
            if (listener != null) {
                listener.onChangeColor(Color.RED);
            }
        }
    }

    /**
     * Setter for whoever wants to listen our fragment
     */
    public void setListener(InteractiveFragmentLister listener) {
        this.listener = listener;
    }

    /**
     * Interface for interacting with activity
     */
    public interface InteractiveFragmentLister {
        void onChangeColor(int color);
    }
}
