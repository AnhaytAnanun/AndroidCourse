package com.flycode.aclesson2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.activities.FragmentAsATagExampleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowActivitySaveStateExample(View view) {
        Intent intent = new Intent(this, SaveStateExampleActivity.class);
        startActivity(intent);
    }

    public void onShowFragmentSaveStateExample(View view) {
        Intent intent = new Intent(this, SaveFragmentStateExampleActivity.class);
        startActivity(intent);
    }

    public void onShowFragmentAsATagExample(View view) {
        Intent intent = new Intent(this, FragmentAsATagExampleActivity.class);
        startActivity(intent);
    }

    public void onShowPassArgumentsToFragmentExample(View view) {
        Intent intent = new Intent(this, FragmentWithArgumentExampleActivity.class);
        startActivity(intent);
    }

    public void onShowFragmentActivityInteractionExample(View view) {
        Intent intent = new Intent(this, InteractiveActivity.class);
        startActivity(intent);
    }
}
