package com.flycode.aclesson2.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.fragments.FragmentOne;
import com.flycode.aclesson2.fragments.FragmentWithAState;

public class SaveFragmentStateExampleActivity extends AppCompatActivity {
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_fragment_state_example);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("current");
        }

        /**
         * Get fragment with tag "content" from FragmentManager.
         * Another way to write this will be:
         * FragmentManager fragmentManager = getFragmentManager();
         * Fragment fragment = fragmentManager.findFragmentByTag("content");
         */
        Fragment fragment = getFragmentManager().findFragmentByTag("content");

        /**
         * Check that there is no fragment added, so we can add default fragment
         */
        if (fragment == null) {
            /**
             * To add fragment, we first must get activity's FragmentManager
             */
            FragmentManager fragmentManager = getFragmentManager();

            /**
             * No, we must start a fragment transaction
             */
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            /**
             * Our only action during this transaction is adding a fragment.
             * We provide tag so we can get this fragment if needed
             */
            fragmentTransaction.add(R.id.container, new FragmentWithAState(), "content");

            /**
             * Add fragment to fragment navigation stack, so it won't be destroyed after being replaced
             */
            fragmentTransaction.addToBackStack(null);

            /**
             * Commit transaction, making our changes actually happen
             */
            fragmentTransaction.commit();

            /**
             * Because getFragmentManager, beginTransaction and add methods return objects,
             * we can just pipe with methods, without saving pointers to objects those methods return:
             *
             * getFragmentManager().beginTransaction().add(R.id.container, new FragmentWithAState(), "content").commit();
             *
             * Or, to make it more readable:
             *
             * getFragmentManager()
             *      .beginTransaction()
             *      .add(R.id.container, new FragmentWithAState(), "content")
             *      .commit();
             */
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current", currentIndex);
    }

    @Override
    public void onBackPressed() {
        if (currentIndex == 1) {
            /**
             * If user is currently on fragment with number 1,
             * then we need to pop that fragment to navigate to default fragment
             */
            currentIndex = 0;
            getFragmentManager().popBackStack();

            return;
        }

        /**
         * If we do not navigate back in fragment stack,
         * then we call super to navigate back to previous activity
         */

        super.onBackPressed();
    }

    public void onShowWithState(View view) {
        /**
         * Just replace current fragment with one user wants to see now
         */

        if (currentIndex == 1) {
            currentIndex = 0;

            /**
             * Because fragment we need is in fragment navigation stack prior to current one,
             * we just pop out current fragment from fragment navigation stack
             */
            getFragmentManager().popBackStack();
        }
    }

    public void onShowWithoutState(View view) {
        /**
         * Just replace current fragment with one user wants to see now
         */

        if (currentIndex == 0) {
            currentIndex = 1;

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new FragmentOne(), "content")

                    /**
                     * We need to add this new fragment to fragment navigation stack,
                     * so it could be popped from it when needed (in onShowWithState and onBackPressed),
                     * to navigate back to other FragmentWithAState fragment.
                     */
                    .addToBackStack(null)
                    .commit();
        }
    }
}
