package edu.temple.coloractivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    boolean isFirstLaunch = true;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        CustomAdapter adapter = new CustomAdapter(getContext(),
                R.layout.support_simple_spinner_dropdown_item, Utility.COLORS);

        Spinner spinner = v.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Inflate the layout for this fragment
        return v;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (!isFirstLaunch) {
            CanvasFragment cf = new CanvasFragment();

            Bundle args = new Bundle();
            args.putInt(Utility.COLOR_INDEX_EXTRA, pos);
            cf.setArguments(args);

            FragmentManager fm = getActivity().getSupportFragmentManager();

            FragmentTransaction transaction = fm.beginTransaction();

            if (getActivity().findViewById(R.id.detail_fragment_container) != null) {
                transaction.replace(R.id.detail_fragment_container, cf);
            } else {
                transaction.add(R.id.master_fragment_container, cf);
            }

            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            isFirstLaunch = false;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
