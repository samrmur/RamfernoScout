package org.ramferno.scoutapplication.ramfernoscout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperVideo extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Video.db";
    private static final int DATABASE_VERSION = 3;
    private static final String CREATE_QUERY = "CREATE TABLE " + DatabaseContractVideo.NewDataInfo.TABLE_NAME + "(" +
            DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH + " TEXT," + DatabaseContractVideo.NewDataInfo.COL_TEAM +
            " TEXT);";

    public DatabaseHelperVideo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Video Database created / opened ...");
    } //End of DatabaseHelperMatch

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Query
        db.execSQL(CREATE_QUERY);

        //Display Log message
        Log.e("DATABASE OPERATIONS", "Match Table created...");
    } //End of onCreate

    public void addInformation(String eVideoPath, String eTeam, SQLiteDatabase db) {
        //Instantiate contentValues
        ContentValues contentValues = new ContentValues();

        //Insert all content values
        contentValues.put(DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH, eVideoPath);
        contentValues.put(DatabaseContractVideo.NewDataInfo.COL_TEAM, eTeam);

        //Insert content values into table
        db.insert(DatabaseContractVideo.NewDataInfo.TABLE_NAME, null, contentValues);

        //Display log message
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    } //End of addInformation

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH, DatabaseContractVideo.NewDataInfo.COL_TEAM};
        cursor = db.query(DatabaseContractVideo.NewDataInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    } //End of getInformation

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    } //End of onUpgrade
} //End of class
