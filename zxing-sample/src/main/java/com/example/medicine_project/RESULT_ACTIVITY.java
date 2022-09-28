package com.example.medicine_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.dm7.barcodescanner.zxing.sample.Drug;
import me.dm7.barcodescanner.zxing.sample.R;

public class RESULT_ACTIVITY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // SimpleScannerActivity 에서 인텐트에 putExtra로 전달했던 클래스
        Drug drug = getIntent().getParcelableExtra("drug");

        // 지금 레이아웃에는 회사명, 약이름, 이미지링크, 바코드번호만 출력할 것이기 때문에
        // 4개의 텍스트뷰만 정의함
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);

        // 약 정보를 출력
        if(drug != null) {
            textView.setText(drug.getCompany());
            textView2.setText(drug.getName());
            textView3.setText(drug.getImage());
            textView4.setText(drug.getBarcode());
        } else {
            textView.setText("NULL");
        }
    }
}