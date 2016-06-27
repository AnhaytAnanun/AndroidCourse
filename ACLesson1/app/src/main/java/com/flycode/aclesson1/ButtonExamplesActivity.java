package com.flycode.aclesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonExamplesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_examples);

        Button manualOneButton = (Button) findViewById(R.id.button_manual_one);
        Button manualTwoButton = (Button) findViewById(R.id.button_manual_two);
        Button manualThreeButton = (Button) findViewById(R.id.button_manual_three);

        /**
         * Inline Implementation for OnClickListener
         */
        manualOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonExamplesActivity.this, "Manual Button One", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Implement OnClickListener somewhere else and pass as a parameter
         */
        manualTwoButton.setOnClickListener(buttonClickListener);

        /**
         * Now ButtonExamplesActivity implements the OnClickListener and its onClick method
         */
        manualThreeButton.setOnClickListener(this);
    }

    public void onButtonClicked(View view) {
        if (view.getId() == R.id.button_with_onclick_one) {
            Toast.makeText(this, "On Button Click for button 1", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.button_with_onclick_two) {
            Toast.makeText(this, "On Button Click for button 2", Toast.LENGTH_SHORT).show();
        }
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ButtonExamplesActivity.this, "Manual Button Two", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        Toast.makeText(ButtonExamplesActivity.this, "Manual Button Three", Toast.LENGTH_SHORT).show();
    }
}
