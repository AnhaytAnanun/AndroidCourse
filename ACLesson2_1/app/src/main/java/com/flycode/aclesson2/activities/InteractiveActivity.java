package com.flycode.aclesson2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.fragments.InteractiveFragment;

public class InteractiveActivity extends AppCompatActivity implements InteractiveFragment.InteractiveFragmentLister {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive);

        InteractiveFragment interactiveFragment = new InteractiveFragment();

        /**
         * Register as a listener for this fragment
         */
        interactiveFragment.setListener(this);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, interactiveFragment)
                .commit();
    }

    @Override
    public void onChangeColor(int color) {
        /**
         * This will be called whenever listener.onChangeColor is called in fragment
         */
        RelativeLayout root = (RelativeLayout) findViewById(R.id.root);
        root.setBackgroundColor(color);
    }
}
