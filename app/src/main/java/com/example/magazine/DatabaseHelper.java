package com.example.magazine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shop_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "shops";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_OPEN_TIME = "open_time";
    private static final String COLUMN_CLOSE_TIME = "close_time";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_OPEN_TIME + " TEXT,"
                + COLUMN_CLOSE_TIME + " TEXT"
                + ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public long insertShop(String name, String address, String openTime, String closeTime) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_OPEN_TIME, openTime);
        values.put(COLUMN_CLOSE_TIME, closeTime);

        long newRowId = db.insert(TABLE_NAME, null, values);
        db.close();

        return newRowId;
    }

    public List<Shop> getAllShops() {
        List<Shop> shopList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_ADDRESS,
                COLUMN_OPEN_TIME,
                COLUMN_CLOSE_TIME
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ADDRESS));
            String openTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPEN_TIME));
            String closeTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLOSE_TIME));

            Shop shop = new Shop(id, name, address, openTime, closeTime);
            shopList.add(shop);
        }

        cursor.close();
        db.close();

        return shopList;
    }
}
