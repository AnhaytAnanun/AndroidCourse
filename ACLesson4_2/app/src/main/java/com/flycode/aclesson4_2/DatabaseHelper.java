package com.flycode.aclesson4_2;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by anhaytananun on 06.07.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "MyDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE MY_TABLE ( NAME TEXT NOT NULL );";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String newString) {
        String insertQuery = "INSERT INTO MY_TABLE VALUES ( " + DatabaseUtils.sqlEscapeString(newString) + " );";

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(insertQuery);
    }

    public ArrayList<String> getContent() {
        SQLiteDatabase db = getReadableDatabase();
        String getQuery = "SELECT * FROM MY_TABLE;";

        Cursor cursor = db.rawQuery(getQuery, null);
        cursor.moveToFirst();

        int textColumnId = cursor.getColumnIndex("NAME");

        ArrayList<String> content = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            String string = cursor.getString(textColumnId);
            content.add(string);
            cursor.moveToNext();
        }

        cursor.close();

        return content;
    }
}
