package com.example.medicine_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import me.dm7.barcodescanner.zxing.sample.R;

public class DetailActivity extends AppCompatActivity {

    Button bt_adlist;

    public String drugstr;
    private DBSearch dBSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // SimpleScannerActivity 에서 인텐트에 putExtra로 전달했던 클래스
        Drug drug = getIntent().getParcelableExtra("drug");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView name_drug = findViewById(R.id.name_drug);
        ImageView detail_image = findViewById(R.id.drugImage);
        TextView companydata = findViewById(R.id.companydata);
        TextView codedata = findViewById(R.id.codedata);
        TextView effectdata = findViewById(R.id.effectdata);
        TextView takedata = findViewById(R.id.takedata);
        TextView cautiondata = findViewById(R.id.cautiondata);
        TextView withWarmdata = findViewById(R.id.withWarmdata);
        TextView eventdata = findViewById(R.id.eventdata);
        TextView storedata = findViewById(R.id.storedata);


        name_drug.setText(drug.getName());
        Glide.with(this).load(drug.getImage()).into(detail_image);
        companydata.setText(drug.getCompany());
        effectdata.setText(drug.getDrugEffect());
        codedata.setText(drug.getId());
        takedata.setText(drug.getTake());
        cautiondata.setText(drug.getCaution());
        withWarmdata.setText(drug.getWithWarm());
        eventdata.setText(drug.getEvent());
        storedata.setText(drug.getStore());

        // 이전 액티비티에서 전달받은 문자열 거져옴
        //drugstr = getIntent().getStringExtra("drugName");

        //dBSearch = new DBSearch(DetailActivity.this);
        //data = dBSearch.search(drugstr);

        //뒤로가기 버튼으로 서치로 돌아가기 (잘 작동 안뎀) 서치에서 받는것도 해야함
        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),FragmentSearch.class);
                intent.putExtra("drugName", drugstr);
                startActivity(intent);
            }
        });

        //목록추가 클릭시 알람 액티비티로 이동과 약 이름 전달 알람액티비티에서 받는것도 해야함
        bt_adlist = findViewById(R.id.bt_adlist);
        bt_adlist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                intent.putExtra("drugName", drugstr);
                startActivity(intent);
            }
        });
    }
}
