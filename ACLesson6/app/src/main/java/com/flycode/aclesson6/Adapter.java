package com.flycode.aclesson6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by anhaytananun on 13.07.16.
 */
public class Adapter extends ArrayAdapter<Thing> {
    private ArrayList<Thing> list;
    private Context myContext;
    public Adapter(Context context, int resource) {
        super(context, resource);
        myContext = context;
        list = new ArrayList<>();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (null == convertView) {
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView info = (TextView) convertView.findViewById(R.id.info);

        name.setText(list.get(position).getName());
        info.setText(list.get(position).getInfo());


        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public void add(Thing object) {
        list.add(object);
        notifyDataSetChanged();
    }
}
