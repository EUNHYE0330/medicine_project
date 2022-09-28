package com.example.medicine_project;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import me.dm7.barcodescanner.zxing.sample.R;

public class FullScreenScannerFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_full_screen_scanner_fragment);
    }
}
