package edu.temple.coloractivity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    boolean isFirstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, Utility.COLORS);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (!isFirstLaunch) {
            CanvasFragment cf = new CanvasFragment();

            Bundle args = new Bundle();
            args.putInt(Utility.COLOR_INDEX_EXTRA, pos);
            cf.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.frame_layout, cf);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();

        } else {
            isFirstLaunch = false;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
