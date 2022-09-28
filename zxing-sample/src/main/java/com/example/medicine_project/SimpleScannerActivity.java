package com.example.medicine_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.dm7.barcodescanner.zxing.sample.Drug;
import me.dm7.barcodescanner.zxing.sample.R;

public class SimpleScannerActivity extends BaseScannerActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    private DBHandler dbHandler;    // DB 클래스 객체
    Drug drug = null;               // 약 클래스 객체
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_simple_scanner);
        setupToolbar();

        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);

        dbHandler = new DBHandler(SimpleScannerActivity.this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        // 스캔한 바코드 번호를 검색 후 반환받은 약 객체를 저장
        drug = dbHandler.search(rawResult.getText());

        // RESULT_ACTIVITY로 검색하고 반환받았던 약 객체를 인텐트로 전달
        Intent intent = new Intent(getApplicationContext(), RESULT_ACTIVITY.class);
        intent.putExtra("drug", drug);
        startActivity(intent);

        {
            // Note:
            // * Wait 2 seconds to resume the preview.
            // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
            // * I don't know why this is the case but I don't have the time to figure out.
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScannerView.resumeCameraPreview(SimpleScannerActivity.this);
                }
            }, 2000);
        }
    }
}
