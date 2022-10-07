package com.example.medicine_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import me.dm7.barcodescanner.zxing.sample.R;

public class RESULT_ACTIVITY extends AppCompatActivity {
    Drug drug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // SimpleScannerActivity 에서 인텐트에 putExtra로 전달했던 클래스
        drug = getIntent().getParcelableExtra("drug");

        Toast.makeText(this,
                drug.getId() + " " +
                drug.getCompany() + " " +
                drug.getDrugEffect() + " " +
                drug.getCaution() + " " +
                drug.getEvent() + " " +
                drug.getBarcode() + " " +
                drug.getImage() + " " +
                drug.getName() + " " +
                drug.getStore() + " " +
                drug.getTake() + " " +
                drug.getWithWarm(), Toast.LENGTH_SHORT).show();

        // 지금 레이아웃에는 회사명, 약이름, 이미지링크, 바코드번호만 출력할 것이기 때문에
        // 4개의 텍스트뷰만 정의함
        TextView drugCompany = findViewById(R.id.drugCompany);
        ImageView drugImage = findViewById(R.id.drugImage);
        TextView drugName = findViewById(R.id.drugName);
        TextView drugCode = findViewById(R.id.drugCode);
        TextView drugEffect = findViewById(R.id.drugEffect);
        TextView drugTake = findViewById(R.id.drugTake);
        TextView drugCaution = findViewById(R.id.drugCaution);
        TextView drugWarning = findViewById(R.id.drugWarning);
        TextView drugEvent = findViewById(R.id.drugEvent);
        TextView drugStore = findViewById(R.id.drugStore);

        // 약 정보를 출력
        if(drug != null) {
            Glide.with(this).load(drug.getImage()).into(drugImage);
            drugCompany.setText(drug.getCompany());
            drugName.setText(drug.getName());
            drugCode.setText(drug.getId());
            drugEffect.setText(drug.getDrugEffect());
            drugTake.setText(drug.getTake());
            drugCaution.setText(drug.getCaution());
            drugWarning.setText(drug.getWithWarm());
            drugEvent.setText(drug.getEvent());
            drugStore.setText(drug.getStore());
        } else {
            drugName.setText("NULL");
        }
    }
}