package com.example.medicine_project;

import android.os.Bundle;

import me.dm7.barcodescanner.zxing.sample.R;

public class FullScannerFragmentActivity extends BaseScannerActivity {
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_full_scanner_fragment);
        setupToolbar();
    }
}