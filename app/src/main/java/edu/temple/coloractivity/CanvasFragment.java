package edu.temple.coloractivity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    int mIndex;

    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.fragment_frame_layout).setBackgroundColor(Color.parseColor(Utility.COLORS[mIndex]));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);
        mIndex = getArguments().getInt(Utility.COLOR_INDEX_EXTRA);

        // Inflate the layout for this fragment
        return v;
    }

}
