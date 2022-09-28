package com.example.medicine_project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.sample.Drug;

public class DBHandler extends SQLiteOpenHelper {

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // db.disableWriteAheadLogging();
    }

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "medicine.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "list";    // 테이블 이름 바꿔서 테스트함

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse() {
    }

    // ================================================================================================================================

    // 스캔한 바코드 번호 문자열을 입력받아
    // 데이터베이스에서 약 정보를 검색한 후
    // 약 객체를 만들어서 반환하는 메서드
    public me.dm7.barcodescanner.zxing.sample.Drug search(String barcode) {
        me.dm7.barcodescanner.zxing.sample.Drug drug = new Drug();
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE `barcode` is " + barcode, null);

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            drug.setCompany(cursorCourses.getString(0));
            drug.setName(cursorCourses.getString(1));
            drug.setImage(cursorCourses.getString(9));
            drug.setBarcode(barcode);
        }
        cursorCourses.close();
        return drug;
    }

    // ================================================================================================================================

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}