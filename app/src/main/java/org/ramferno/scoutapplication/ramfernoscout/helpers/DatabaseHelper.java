package org.ramferno.scoutapplication.ramfernoscout.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContract;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Scout.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE " + DatabaseContract.NewDataInfo.TABLE_NAME + "(" + DatabaseContract.NewDataInfo.COL_NUMBER +
            " INTEGER," + DatabaseContract.NewDataInfo.COL_PORTCULLIS + " TEXT," + DatabaseContract.NewDataInfo.COL_CHEVAL_FRISE + " TEXT," +
            DatabaseContract.NewDataInfo.COL_MOAT + " TEXT," + DatabaseContract.NewDataInfo.COL_RAMPARTS + " TEXT," +
            DatabaseContract.NewDataInfo.COL_DRAWBRIDGE + " TEXT," + DatabaseContract.NewDataInfo.COL_SALLY_PORT + " TEXT," +
            DatabaseContract.NewDataInfo.COL_ROCK_WALL + " TEXT," + DatabaseContract.NewDataInfo.COL_ROCK_TERRAIN + " TEXT," +
            DatabaseContract.NewDataInfo.COL_LOW_BAR + " TEXT," + DatabaseContract.NewDataInfo.COL_AUTO_HIGH + " TEXT," +
            DatabaseContract.NewDataInfo.COL_AUTO_LOW + " TEXT," + DatabaseContract.NewDataInfo.COL_TELE_HIGH + " TEXT," +
            DatabaseContract.NewDataInfo.COL_TELE_LOW + " TEXT," + DatabaseContract.NewDataInfo.COL_TELE_PLAY + " TEXT," +
            DatabaseContract.NewDataInfo.COL_HANG + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened ...");
    } //End of DatabaseHelper

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Query
        db.execSQL(CREATE_QUERY);

        //Display Log message
        Log.e("DATABASE OPERATIONS", "Table created...");
    } //End of onCreate

    public void addInformation(String eNumber, String ePortcullis, String eChevalFrise, String eMoat, String eRamparts, String eDrawbridge, String eSallyPort,
                               String eRockWall, String eRockTerrain, String eLowBar, String eAutoHigh, String eAutoLow, String eTeleHigh, String eTeleLow,
                               String eTelePlay, String eHang, SQLiteDatabase db) {
        //Instantiate contentValues
        ContentValues contentValues = new ContentValues();

        //Insert all content values
        contentValues.put(DatabaseContract.NewDataInfo.COL_NUMBER, eNumber);
        contentValues.put(DatabaseContract.NewDataInfo.COL_PORTCULLIS, ePortcullis);
        contentValues.put(DatabaseContract.NewDataInfo.COL_CHEVAL_FRISE, eChevalFrise);
        contentValues.put(DatabaseContract.NewDataInfo.COL_MOAT, eMoat);
        contentValues.put(DatabaseContract.NewDataInfo.COL_RAMPARTS, eRamparts);
        contentValues.put(DatabaseContract.NewDataInfo.COL_DRAWBRIDGE, eDrawbridge);
        contentValues.put(DatabaseContract.NewDataInfo.COL_SALLY_PORT, eSallyPort);
        contentValues.put(DatabaseContract.NewDataInfo.COL_ROCK_WALL, eRockWall);
        contentValues.put(DatabaseContract.NewDataInfo.COL_ROCK_TERRAIN, eRockTerrain);
        contentValues.put(DatabaseContract.NewDataInfo.COL_LOW_BAR, eLowBar);
        contentValues.put(DatabaseContract.NewDataInfo.COL_AUTO_HIGH, eAutoHigh);
        contentValues.put(DatabaseContract.NewDataInfo.COL_AUTO_LOW, eAutoLow);
        contentValues.put(DatabaseContract.NewDataInfo.COL_TELE_HIGH, eTeleHigh);
        contentValues.put(DatabaseContract.NewDataInfo.COL_TELE_LOW, eTeleLow);
        contentValues.put(DatabaseContract.NewDataInfo.COL_TELE_PLAY, eTelePlay);
        contentValues.put(DatabaseContract.NewDataInfo.COL_HANG, eHang);

        //Insert content values into table
        db.insert(DatabaseContract.NewDataInfo.TABLE_NAME, null, contentValues);

        //Display log message
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    } //End of addInformation

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {DatabaseContract.NewDataInfo.COL_NUMBER, DatabaseContract.NewDataInfo.COL_PORTCULLIS,
                DatabaseContract.NewDataInfo.COL_CHEVAL_FRISE, DatabaseContract.NewDataInfo.COL_MOAT,DatabaseContract.NewDataInfo.COL_RAMPARTS,
                DatabaseContract.NewDataInfo.COL_DRAWBRIDGE, DatabaseContract.NewDataInfo.COL_SALLY_PORT, DatabaseContract.NewDataInfo.COL_ROCK_WALL,
                DatabaseContract.NewDataInfo.COL_ROCK_TERRAIN, DatabaseContract.NewDataInfo.COL_LOW_BAR, DatabaseContract.NewDataInfo.COL_AUTO_HIGH,
                DatabaseContract.NewDataInfo.COL_AUTO_LOW, DatabaseContract.NewDataInfo.COL_TELE_HIGH, DatabaseContract.NewDataInfo.COL_TELE_LOW,
                DatabaseContract.NewDataInfo.COL_TELE_PLAY, DatabaseContract.NewDataInfo.COL_HANG};
        cursor = db.query(DatabaseContract.NewDataInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    } //End of getInformation

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    } //End of onUpgrade
} //End of class

