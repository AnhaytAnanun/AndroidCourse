package com.flycode.aclesson2.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.flycode.aclesson2.R;
import com.flycode.aclesson2.activities.FragmentAsATagExampleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.my_list);
        myListView.setAdapter(new MyAdapter(this));
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
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

    private class MyAdapter extends ArrayAdapter<String> {
        private Context context;
        private int contentArray[] = {
                R.string.fragment_activity_interaction_example,
                R.string.fragment_as_a_tag_example,
                R.string.fragment_save_state_example,
                R.string.fragment_with_state,
                R.string.activity_save_state_example
        };

        public MyAdapter(Context context) {
            super(context, R.layout.main_list_item);

            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.main_list_item, parent, false);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(contentArray[position]);

            return convertView;
        }

        @Override
        public int getCount() {
            return contentArray.length;
        }

        @Override
        public String getItem(int position) {
            return super.getItem(position);
        }
    }
}
