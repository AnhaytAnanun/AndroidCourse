package com.flycode.aclesson2.activities;

import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.fragments.FragmentWithArgument;

import java.util.Date;

public class FragmentWithArgumentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_with_argument_example);

        UserManager userManager = (UserManager) getSystemService(USER_SERVICE);

        FragmentWithArgument fragment = FragmentWithArgument.createInstance("John Targaryan", new Date(), 13, userManager.isUserAGoat());

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
