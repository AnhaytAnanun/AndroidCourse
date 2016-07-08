package com.flycode.aclesson4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonOne);

        ListView listView = (ListView) findViewById(R.id.list_View);
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> savedContent = databaseHelper.getContent();

        final CustomAdapter adapter = new CustomAdapter(this, savedContent);

        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myText = (EditText) findViewById(R.id.edit_Text);
                String myString = myText.getText().toString();
                databaseHelper.insert(myString);
                myText.setText("");
                adapter.add(myString);
            }
        });
    }
}
