package edu.temple.coloractivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        int index = intent.getIntExtra(Utility.COLOR_INDEX_EXTRA, -1);
        if (index != -1) {
            String color = Utility.COLORS[index];
            findViewById(R.id.canvas_layout).setBackgroundColor(Color.parseColor(color));
        } else {
            Toast.makeText(this, "Invalid index passed to this activity",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
