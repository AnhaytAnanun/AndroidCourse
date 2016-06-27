package com.flycode.aclesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultExampleActivity extends AppCompatActivity {
    public static String RESPONSE_EXTRA = "responseExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_example);

        // Get string extra send from StartExampleActivity
        String textPassed = getIntent().getStringExtra(StartExampleActivity.SOME_TEXT_EXTRA);

        // Set passed string to TextView
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(textPassed);
    }

    public void onAngryResponse(View view) {
        // Create new intent. We use empty constructor here,
        // as there is no need to pass Activity class ot Context.
        // Put response as an extra
        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EXTRA, "SHUT UP!");

        // Set result to send back
        setResult(RESULT_OK, intent);

        // We are, we can finish this activity :)
        finish();
    }

    public void onKindResponse(View view) {
        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EXTRA, "Interesting... !");

        setResult(RESULT_OK, intent);
        finish();
    }
}
