package com.flycode.aclesson5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

public class AnimationExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_examples);
    }

    public void onScaling(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);

        /** The code below will do the same thing as animation loaded from xml
         *
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, // fromXScale
                0.5f, // toXScale
                1.0f, // fromYScale
                1.5f); // toYScale
         animation.setDuration(2000);
         */

        view.startAnimation(animation);
    }

    public void onRotating(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotation);

        /** The code below will do the same thing as animation loaded from xml
         *
         AccelerateInterpolator interpolator = new AccelerateInterpolator(3); // Accelerate Interpolator, cubic
         RotateAnimation animation = new RotateAnimation(
         0, // fromDegree
         90, // toDegree
         0.5f, // pivotX. Note that it is 0.5, not 50 as in xml
         0.5f // pivotY. Note that it is 0.5, not 50 as in xml
         );
         animation.setDuration(2000);
         animation.setInterpolator(interpolator); // Set interpolator
         */

        view.startAnimation(animation);
    }

    public void onAlpha(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        /** The code below will do the same thing as animation loaded from xml
         *
         ScaleAnimation animation = new AlphaAnimation(
         1.0f, // fromAlpha
         0.5f, // toAlpha
         animation.setDuration(2000);
         */

        view.startAnimation(animation);
    }

    public void onTranslate(View view) {
        /**
         * TODO: Add Translate Animation For This View
         */
    }
}
