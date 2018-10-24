package edu.temple.coloractivity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    int mIndex;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("position");
        } else {
            Bundle args = getArguments();
            if (args != null) {
                mIndex = args.getInt(Utility.COLOR_INDEX_EXTRA);
            } else {
                mIndex = 0;
            }
        }

        FrameLayout frame = v.findViewById(R.id.canvas_layout);
        frame.setBackgroundColor(Color.parseColor(Utility.COLORS[mIndex]));

        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mIndex);
    }
}
