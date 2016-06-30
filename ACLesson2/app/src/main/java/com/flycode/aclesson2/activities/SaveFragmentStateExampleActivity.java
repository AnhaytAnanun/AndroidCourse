package com.flycode.aclesson2.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.fragments.FragmentOne;
import com.flycode.aclesson2.fragments.FragmentWithAState;

public class SaveFragmentStateExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_fragment_state_example);

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

    public void onShowWithState(View view) {
        /**
         * Just replace current fragment with one user wants to see now
         */
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new FragmentWithAState(), "content")
                .commit();

    }

    public void onShowWithoutState(View view) {
        /**
         * Just replace current fragment with one user wants to see now
         */
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new FragmentOne(), "content")
                .commit();
    }
}
