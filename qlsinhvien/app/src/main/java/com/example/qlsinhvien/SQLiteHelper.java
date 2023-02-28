package com.example.qlsinhvien;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "QLSinhVien";
    public static final int VERSION= 1;
    public static final String ID = "id";
    public static final String HO_VA_TEN = "ho_va_ten";
    public static final String TABLE_SINHVIEN = "table_sinhvien";
    public static final String CREATE_TABLE = "create table " + TABLE_SINHVIEN + "  ( " + ID + " integer primary key autoincrement , " + HO_VA_TEN + " text not null )";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SINHVIEN);
        onCreate(sqLiteDatabase);

    }
}
