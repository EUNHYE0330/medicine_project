package com.example.medicine_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import me.dm7.barcodescanner.zxing.sample.R;

import java.util.List;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    // 프래그먼트 객체 생성
    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;

    // 탭 버튼 객체 생성
    private Button bt_tab1, bt_tab2, bt_tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 위젯에 대한 참조
        bt_tab1 = findViewById(R.id.bt_tab1);
        bt_tab2 = findViewById(R.id.bt_tab2);
        bt_tab3 = findViewById(R.id.bt_tab3);

        // 탭 버튼에 대한 리스너 연결
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);
        bt_tab3.setOnClickListener(this);

        // 어느 프레그먼트를 처음으로 프레임레이아웃에 띄울 것인지를 결정
        callFragment(FRAGMENT1);
        initLoadDrugDatabase();
    }
    // 프래그먼트 클릭시
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 첫번째 tab 클릭시
            case R.id.bt_tab1 :
                // FRAGMENT 1 보여줌
                callFragment(FRAGMENT1);
                break;
            // 두번째 tab 클릭시
            case R.id.bt_tab2 :
                // FRAGMENT 2 보여줌
                callFragment(FRAGMENT2);
                break;
            // 세번째 tab 클릭시
            case R.id.bt_tab3 :
                // FRAGMENT 3 보여줌
                callFragment(FRAGMENT3);
                break;

        }
    }

    private void callFragment(int frament_no){
        // 프래그먼트 사용을 위해 transaction 정의
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // '메인화면'프래그먼트 호출
                FragmentMain fragmentMain = new FragmentMain();
                transaction.replace(R.id.fragment_container, fragmentMain);
                transaction.commit();
                break;

            case 2:
                // '약 검색'프래그먼트 호출
                FragmentSearch fragmentSearch = new FragmentSearch();
                transaction.replace(R.id.fragment_container, fragmentSearch);
                transaction.commit();
                break;

            case 3:
                // '설정'프래그먼트 호출
                FragmentSetting fragmentSetting = new FragmentSetting();
                transaction.replace(R.id.fragment_container, fragmentSetting);
                transaction.commit();
                break;
        }

    }
    public List<Drug> initLoadDrugDatabase(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.OpenDatabaseFile();

        List<Drug> drugList = databaseHelper.getTableData();
        Log.e("test", String.valueOf(drugList.size()));

        databaseHelper.close();
        return drugList;
    }
}