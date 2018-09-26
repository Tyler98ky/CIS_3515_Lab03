package edu.temple.coloractivity;

import android.content.Intent;
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
            Intent canvasIntent = new Intent(getApplicationContext(), CanvasActivity.class);
            canvasIntent.putExtra(Utility.COLOR_INDEX_EXTRA, pos);
            startActivity(canvasIntent);
        } else {
            isFirstLaunch = false;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
