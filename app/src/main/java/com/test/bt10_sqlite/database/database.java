package com.test.bt10_sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;

import com.test.bt10_sqlite.Computer;
import com.test.bt10_sqlite.Loai;

public class database extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "QLCOMPUTER";

    private static String TABLE_LOAI = "tbLoai";
    private static String MA_LOAI = "maLoai";
    private static String TEN_LOAI = "tenLoai";
    private static String SO_LUONG = "soLuong";


    private static String TABLE_COMPUTER = "tbComputer";
    private static String MA_MAY = "maMay";
    private static String TEN_MAY = "tenMay";
    private static String GIA = "gia"        ;

    private String SQLQuery = "CREATE TABLE "+ TABLE_LOAI+" ( "+MA_LOAI+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_LOAI+ " TEXT, "
            +SO_LUONG+ " INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_COMPUTER+" ( "+MA_MAY+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_MAY+ " TEXT, "
            +GIA+" TEXT, "
            +MA_LOAI+" INTEGER, FOREIGN KEY ( "+MA_LOAI+" ) REFERENCES "+
            TABLE_LOAI+"("+MA_LOAI+"))";


    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddLoai(Loai loai){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MA_LOAI, loai.getMaLoai());
        values.put(TEN_LOAI, loai.getTenLoai());
        values.put(SO_LUONG, loai.getSoLuong());

        db.insert(TABLE_LOAI, null, values);
        db.close();
    }
    public boolean UpdateLoai(Loai loai, int maLoai){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MA_LOAI, loai.getMaLoai());
        values.put(TEN_LOAI, loai.getTenLoai());
        values.put(SO_LUONG, loai.getSoLuong());

        db.update(TABLE_LOAI, values, MA_LOAI+" = "+maLoai, null);
        return true;
    }

    public Cursor getDataLoai(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_LOAI,null);
        return cursor;
    }

    public int DeleteLoai(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_LOAI, MA_LOAI+" = "+i,null);
        return res;
    }

    public int DeleteComputer(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_COMPUTER, MA_MAY +" = "+i,null);
        return res;
    }

    public void AddComputer(Computer computer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MA_MAY, computer.getMaMay());
        values.put(TEN_LOAI, computer.getTenMay());
        values.put(GIA, computer.getGia());
        values.put(MA_LOAI, computer.getMaLoai());

        db.insert(TABLE_COMPUTER, null, values);
        db.close();
    }

    public Cursor getDataComputer(int maLoai){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_COMPUTER+" WHERE "+MA_LOAI+" = "+maLoai,null);
        return res;
    }
}
