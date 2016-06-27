package com.flycode.aclesson1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST = 109;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowTextViewExamples(View view) {
        Intent intent = new Intent(this, TextViewExamplesActivity.class);
        startActivity(intent);
    }

    public void onShowButtonExamples(View view) {
        Intent intent = new Intent(this, ButtonExamplesActivity.class);
        startActivity(intent);
    }

    public void onShowActivityStartResultExample(View view) {
        Intent intent = new Intent(this, StartExampleActivity.class);
        startActivity(intent);
    }

    public void onShowRelativeLayoutExample(View view) {
        Intent intent = new Intent(this, RelativeLayoutExampleActivity.class);
        startActivity(intent);
    }

    public void onShowLinearLayoutExample(View view) {
        Intent intent = new Intent(this, LinearLayoutExampleActivity.class);
        startActivity(intent);
    }
}
