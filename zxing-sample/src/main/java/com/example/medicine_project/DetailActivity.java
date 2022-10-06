package com.example.medicine_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.sample.R;
import me.dm7.barcodescanner.zxing.sample.Drug;

public class DetailActivity extends AppCompatActivity {
    TextView name_drug;
    TextView companydata;
    TextView codedata;
    TextView effectdata;
    TextView takedata;
    TextView cautiondata;
    TextView withWarmdata;
    TextView eventdata;
    TextView storedata;

    Button bt_adlist;
    ImageView btn_back;
    ImageView detail_image;

    public String drugstr;
    private DBSearch dBSearch;
    Drug data = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name_drug = findViewById(R.id.name_drug);
        detail_image = findViewById(R.id.detail_image);
        companydata = findViewById(R.id.companydata);
        effectdata = findViewById(R.id.effectdata);
        codedata = findViewById(R.id.codedata);
        takedata = findViewById(R.id.takedata);
        cautiondata = findViewById(R.id.cautiondata);
        withWarmdata = findViewById(R.id.withWarmdata);
        eventdata = findViewById(R.id.eventdata);
        storedata = findViewById(R.id.storedata);

        // 이전 액티비티에서 전달받은 문자열 거져옴
        drugstr = getIntent().getStringExtra("drugName");

        dBSearch = new DBSearch(DetailActivity.this);
        data = dBSearch.search(drugstr);

        //뒤로가기 버튼으로 서치로 돌아가기 (잘 작동 안뎀) 서치에서 받는것도 해야함
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),FragmentSearch.class);
                intent.putExtra("drugName", drugstr);
                startActivity(intent);
            }
        });

        name_drug.setText(data.getName());
        Glide.with(this).load(data.getImage()).into(detail_image);
        companydata.setText(data.getCompany());
        effectdata.setText(data.getDrugEffect());
        codedata.setText(data.getId());
        takedata.setText(data.getTake());
        cautiondata.setText(data.getCaution());
        withWarmdata.setText(data.getWithWarm());
        eventdata.setText(data.getEvent());
        storedata.setText(data.getStore());

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
