package com.example.medicine_project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import me.dm7.barcodescanner.zxing.sample.R;

public class AlarmActivity extends AppCompatActivity {
    ImageView btn_back;
    EditText medi, memo;
    Spinner medi_count_list;
    TextView alarmtime1, alarmtime2, alarmtime3;
    Button timeplus, btn_save;
    Integer[] day_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        //뒤로가기 버튼
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });

        //용량 스피너 설정
        Spinner spn = findViewById(R.id.medi_count_list);

        ArrayAdapter<CharSequence> spn_adapter = ArrayAdapter.createFromResource(this, R.array.medi_count, android.R.layout.simple_spinner_item);
        spn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(spn_adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                Toast.makeText(parent.getContext(), "선택된 용량은 " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });

        //요일 버튼 클릭 시 색 변경
        final Button[] day = new Button[7];
        final Integer[] dayID = {R.id.mon, R.id.tue, R.id.wed, R.id.thu, R.id.fri, R.id.sat, R.id.sun};
        int i;
        day_array = new Integer[7];
        for (i = 0; i < dayID.length; i++) {
            day[i] = (Button) findViewById(dayID[i]);
            day_array[i] = 0;
        }

        for (i = 0; i < dayID.length; i++) {
            final int index;
            index = i;
            day[index].setOnClickListener(view -> {
                if (day[index].getCurrentTextColor() == Color.BLACK) {
                    day[index].setBackgroundResource(R.drawable.primary_border_fill); //배경 색상
                    day[index].setTextColor(Color.WHITE); //텍스트 색상
                    day_array[index] = 1;
                }
                else{
                    day[index].setBackgroundResource(R.drawable.primary_border_fill3);
                    day[index].setTextColor(Color.BLACK);
                    day_array[index] = 0;
                }
            });
        }

        //시간 추가하기 버튼
        timeplus = findViewById(R.id.timeplus);
        timeplus.setOnClickListener(view -> {
            TimePickerFragment mTimePickerFragment = new TimePickerFragment();
            mTimePickerFragment.show(getSupportFragmentManager(), TimePickerFragment.FRAGMENT_TAG);
        });

        alarmtime1 = findViewById(R.id.alarmtime1);
        alarmtime2 = findViewById(R.id.alarmtime2);
        alarmtime3 = findViewById(R.id.alarmtime3);
    }
}