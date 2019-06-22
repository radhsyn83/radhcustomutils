package com.segamedev.radhsyn83;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.segamedev.myutils.RadhUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, new RadhUtils().toRupiahFormat("120000"), Toast.LENGTH_LONG).show();
    }
}
