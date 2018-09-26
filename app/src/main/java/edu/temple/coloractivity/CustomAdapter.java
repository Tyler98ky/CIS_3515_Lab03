package edu.temple.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {


    String[] mColors;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        mColors = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String color = mColors[position];

        TextView tv = (TextView) super.getView(position, convertView, parent);
        tv.setText(color);
        tv.setBackgroundColor(Color.parseColor(color));

        return tv;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String color = mColors[position];

        TextView tv = (TextView) super.getDropDownView(position, convertView, parent);
        tv.setBackgroundColor(Color.parseColor(color));

        return tv;
    }
}
