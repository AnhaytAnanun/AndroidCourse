package com.flycode.aclesson5;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ObjectAnimatorExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator_examples);
    }

    public void onMakeAnimation(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        animator.setTarget(view);
        animator.start();

        /** Or, we can create objectAnimator manually

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0, 45);
        objectAnimator.start();

         */
    }
}
