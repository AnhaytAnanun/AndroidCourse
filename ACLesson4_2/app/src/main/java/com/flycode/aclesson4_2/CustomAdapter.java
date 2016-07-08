package com.flycode.aclesson4_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anhaytananun on 06.07.16.
 */
public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<String> content;

    public CustomAdapter(Context context, ArrayList<String> content) {
        super(context, R.layout.item_row);

        this.context = context;
        this.content = content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_row, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(content.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return content.size();
    }

    public void add(String string) {
        content.add(string);
        notifyDataSetChanged();
    }
}
