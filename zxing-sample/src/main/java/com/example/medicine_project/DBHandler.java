package com.example.medicine_project;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

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
    private static final String TABLE_NAME = "drug";    // 테이블 이름 바꿔서 테스트함

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
    public Drug search(String barcode) {
        Drug drug = new Drug();
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // 숫자로 시작하고  13자리 길이면 바코드로 인식캐서 바코드 쿼리 실행
        if( (barcode.length() == 13) && (barcode.charAt(0) >= '0') && barcode.charAt(0) <= '9' ){
            // on below line we are creating a cursor with query to read data from database.
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE `barcode` is " + barcode, null);

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
                drug.setBarcode(barcode);
            }
            cursor.close();
        } else {
            // on below line we are creating a cursor with query to read data from database.
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE `drugName` is " + barcode, null);

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
                drug.setBarcode(barcode);
            }
            cursor.close();
        }


        return drug;
    }


    // ================================================================================================================================

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}










