package com.flycode.aclesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StartExampleActivity extends AppCompatActivity {
    public static final String SOME_TEXT_EXTRA = "someTextExtra";

    private static final int REQUEST_CODE = 109;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onStartNewActivity(View view) {
        // Get typed string from EditText
        EditText editText = (EditText) findViewById(R.id.input);
        String input = editText.getText().toString();

        // Create Intent.
        // We pass Context (this, AppCompatActivity extends Context)
        // and class of activity we want to create.
        Intent startIntent = new Intent(this, ResultExampleActivity.class);

        // Put user's string as an extra
        startIntent.putExtra(SOME_TEXT_EXTRA, input);

        // Start activity. We use startActivityForResult,
        // so ResultExampleActivity can send us result back
        startActivityForResult(startIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that this response from activity we need
        if (requestCode == REQUEST_CODE) {
            // Get response string
            String response = data.getStringExtra(ResultExampleActivity.RESPONSE_EXTRA);

            // Put it in textview
            TextView textView = (TextView) findViewById(R.id.response);
            textView.setText(response);
        }
    }
}
