package com.example.notes_app;

import android.app.LauncherActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseModel extends SQLiteOpenHelper {


    public static final String NOTES_TABLE = "NOTES_TABLE";
    public static final String COLUMN_NOTES_TITLE = "NOTES_TITLE";
    public static final String COLUMN_NOTES_NOTES = "NOTES_NOTES";
    public static final String CUSTOMER_ID = "ID";


    public DatabaseModel(@Nullable Context context) {
        super(context, "Notes_title.db" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryString = "CREATE TABLE " + NOTES_TABLE + " (" + CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOTES_TITLE + " TEXT , " + COLUMN_NOTES_NOTES + " TEXT)";

        db.execSQL(queryString);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean add_notes(NoteModel noteModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOTES_TITLE , noteModel.getTitle());
        cv.put(COLUMN_NOTES_NOTES, noteModel.getNotes());
        long insert = db.insert(NOTES_TABLE, null , cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<NoteModel> get_notes() {
        SQLiteDatabase db = getReadableDatabase();
        List<NoteModel> returnList = new ArrayList<>();

        String stringQuery = "SELECT * FROM " + NOTES_TABLE;
        Cursor cursor = db.rawQuery(stringQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String notes = cursor.getString(2);
                NoteModel nm = new NoteModel(notes , title, id);
                returnList.add(nm);
            }while (cursor.moveToNext());
        }else{
            // Don't do anything if failure
        }

        cursor.close();
        return returnList;
    }

    public List<NoteModel> delete_note(View view) {
        SQLiteDatabase db = getWritableDatabase();
        List<NoteModel> returnList = new ArrayList<>();

        String stringQuery = "SELECT * FROM " + NOTES_TABLE;
        Cursor cursor = db.rawQuery(stringQuery , null);

        if(cursor.moveToFirst()){
            returnList.remove(view);
        }

        return returnList;
    }
}
