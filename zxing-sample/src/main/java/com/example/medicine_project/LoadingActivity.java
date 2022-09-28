package com.example.medicine_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import me.dm7.barcodescanner.zxing.sample.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //로딩화면 시작
        Loadingstart();
    }
    private void Loadingstart(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}