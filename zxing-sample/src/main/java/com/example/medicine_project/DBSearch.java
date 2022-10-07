package com.example.medicine_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSearch extends SQLiteOpenHelper {

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // db.disableWriteAheadLogging();
    }

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "drug.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "drug";

    // creating a constructor for our database handler.
    public DBSearch(Context context) {
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
    public Drug search(String drugName) {
        Drug drug = new Drug();
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();
        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE `drugName` is " + drugName, null);

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            drug.setCompany(cursor.getString(0));
            drug.setName(cursor.getString(1));
            drug.setId(cursor.getString(2));
            drug.setDrugEffect(cursor.getString(3));
            drug.setTake(cursor.getString(4));
            drug.setCaution(cursor.getString(5));
            drug.setWithWarm(cursor.getString(6));
            drug.setEvent(cursor.getString(7));
            drug.setStore(cursor.getString(8));
            drug.setImage(cursor.getString(9));
            drug.setBarcode(cursor.getString(10));
        }
        cursor.close();
        return drug;
    }

    // ================================================================================================================================

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}