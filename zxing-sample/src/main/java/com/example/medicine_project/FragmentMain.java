package com.example.medicine_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.dm7.barcodescanner.zxing.sample.R;

public class FragmentMain extends ListFragment  {

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        frameLayout = (FrameLayout) getView().findViewById(R.id.frameLayout);
        // inflate the layout of the popup window
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_modify, null);
        ViewGroup container =(ViewGroup) layoutInflater.inflate(R.layout.popup_modify, null);
        popupWindow = new PopupWindow(container, 750, 250, true);
        popupWindow.showAtLocation(frameLayout, Gravity.NO_GRAVITY, 180, 1350);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        String[] userList = {"아네모정"};
        ListView l = (ListView) view.findViewById(R.id.list_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.single_row, R.id.rowTextView, userList);
        setListAdapter(adapter);

        //l.setOnItemClickListener();


        //fragment에서 버튼 클릭으로 activity로 이동하기
        Button alarmButton = view.findViewById(R.id.bt_setAR);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AlarmActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;
    }

}