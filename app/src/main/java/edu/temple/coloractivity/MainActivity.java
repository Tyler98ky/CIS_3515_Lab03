package edu.temple.coloractivity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaletteFragment pf = new PaletteFragment();
        CanvasFragment cf  = new CanvasFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.master_fragment_container, pf);

        if (findViewById(R.id.detail_fragment_container) != null) {
            transaction.replace(R.id.detail_fragment_container, cf);
        }

        // Commit the transaction
        transaction.commit();

    }
}
