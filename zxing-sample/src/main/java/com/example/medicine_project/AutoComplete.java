package com.example.medicine_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AutoComplete extends DatabaseHelper {
    private SQLiteDatabase db;
    private static String tableName = "drug"; // 테이블 이름
    private String drugName = "drugName";

    public AutoComplete(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //검색기능
    @SuppressLint("Range")
    public ArrayList<String> getName() {
        ArrayList<String> DrugList = new ArrayList<>();
        db = this.getWritableDatabase();

        //Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName + " WHERE `drugName` is " + drugName, null);
        cursor.moveToFirst(); //커서 포인터위치를 첫번째 레코드 위치로 이동

        while (!cursor.isAfterLast()) { //현재 커서 포인터위치에서 다음 레코드가 있는지 확인. 즉 마지막 레코드(=true)인지 확인. 마지막 레코드일때까지 반복
            String dl = cursor.getString(cursor.getColumnIndex(drugName));
            DrugList.add(dl);
            cursor.moveToNext();//커서 포인터 위치를 다음 레코드 위치로 이동
        }
        cursor.close();
        return DrugList;
    }
}
