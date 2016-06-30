package com.flycode.aclesson2.activities;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.flycode.aclesson2.R;

public class SaveStateExampleActivity extends AppCompatActivity {
    private static final String SAVED_INPUT = "savedInput";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state_example);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        /**
         * Note, this code can be put in onCreate, too
         */

        if (savedInstanceState != null) {
            /**
             * Retrieve text for EditText from savedInstanceState bundle
             */

            String savedInput = savedInstanceState.getString(SAVED_INPUT);

            EditText editText = (EditText) findViewById(R.id.input);
            editText.setText(savedInput);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /**
         * Put text of EditText into outState bundle
         */

        EditText editText = (EditText) findViewById(R.id.input);
        outState.putString(SAVED_INPUT, editText.getText().toString());
    }
}
