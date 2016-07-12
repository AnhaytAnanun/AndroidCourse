package com.flycode.aclesson5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowAnimationExamples(View view) {
        Intent intent = new Intent(this, AnimationExamplesActivity.class);
        startActivity(intent);
    }

    public void onShowObjectAnimatorExamples(View view) {
        Intent intent = new Intent(this, ObjectAnimatorExamplesActivity.class);
        startActivity(intent);
    }

    public void onShowValueAnimatorExamples(View view) {
        Intent intent = new Intent(this, ValueAnimatorExampleActivity.class);
        startActivity(intent);
    }

    public void onShowHackerTyperExamples(View view) {
    }
}