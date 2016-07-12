package com.flycode.aclesson5;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ValueAnimatorExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_example);
    }

    public void onChangeColor(final View view) {
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(
                0,
                view.getMeasuredHeight() // Getting the height of the view
        );
        /**
         * The onAnimationUpdate of AnimatorUpdateListener will be called on each animation step
         * We just need to get new animated value, and do want we want - translating view's X and Y position this time
         */
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                view.setX(value);
                view.setY(value);
            }
        });
        valueAnimator.start();
    }
}
