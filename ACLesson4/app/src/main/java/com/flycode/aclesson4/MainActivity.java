package com.flycode.aclesson4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText1 = (EditText) findViewById(R.id.text1);
        EditText editText2 = (EditText) findViewById(R.id.text2);
        EditText editText3 = (EditText) findViewById(R.id.text3);

        Context context = getApplicationContext();

        SharedPreferences myPreferences = context.getSharedPreferences("MyPreferences", 0);
        editText1.setText(myPreferences.getString("String1", ""));
        editText2.setText(myPreferences.getString("String2", ""));
        editText3.setText(myPreferences.getString("String3", ""));
    }

    public void saveData(View view) {
        EditText editText1 = (EditText) findViewById(R.id.text1);
        EditText editText2 = (EditText) findViewById(R.id.text2);
        EditText editText3 = (EditText) findViewById(R.id.text3);

        String strText1 = editText1.getText().toString();
        String strText2 = editText2.getText().toString();
        String strText3 = editText3.getText().toString();

        SharedPreferences myPreferences = getSharedPreferences("MyPreferences", 0);
        Editor editor = myPreferences.edit();
        editor.putString("String1", strText1);
        editor.putString("String2", strText2);
        editor.putString("String3", strText3);
        editor.commit();
    }

}
