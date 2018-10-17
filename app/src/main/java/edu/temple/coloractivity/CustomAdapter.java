package edu.temple.coloractivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.print.PrintAttributes;
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

        Resources res = getContext().getResources();
        String[] colors = res.getStringArray(R.array.string_array_name);

        TextView tv = (TextView) super.getView(position, convertView, parent);
        tv.setText(colors[position]);
        tv.setBackgroundColor(Color.parseColor(color));

        return tv;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String color = mColors[position];

        Resources res = getContext().getResources();
        String[] colors = res.getStringArray(R.array.string_array_name);

        TextView tv = (TextView) super.getDropDownView(position, convertView, parent);
        tv.setText(colors[position]);
        tv.setBackgroundColor(Color.parseColor(color));

        return tv;
    }
}
