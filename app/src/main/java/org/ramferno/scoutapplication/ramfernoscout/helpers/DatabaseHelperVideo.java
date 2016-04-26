package org.ramferno.scoutapplication.ramfernoscout.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractVideo;

public class DatabaseHelperVideo extends SQLiteOpenHelper {
    //Declares and initializes all database string variables
    public static final String DATABASE_NAME = "Video.db";
    private static final int DATABASE_VERSION = 3;
    private static final String CREATE_QUERY = "CREATE TABLE " + DatabaseContractVideo.NewDataInfo.TABLE_NAME + "(" +
            DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH + " TEXT," + DatabaseContractVideo.NewDataInfo.COL_TEAM +
            " TEXT);";

    public DatabaseHelperVideo(Context context) {
        //Calls on context, the database name and the database version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //Creates log report hat indicates the database has either been created or opened
        Log.e("DATABASE OPERATIONS", "Video Database created / opened ...");
    } //End of DatabaseHelperMatch

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creates query
        db.execSQL(CREATE_QUERY);

        //Displays log message that indicates a table has been created
        Log.e("DATABASE OPERATIONS", "Match Table created...");
    } //End of onCreate

    //This method will add information into the string values in the corresponding database contract
    public void addInformation(String eVideoPath, String eTeam, SQLiteDatabase db) {
        //Declares and instantiates object
        ContentValues contentValues = new ContentValues();

        //Inserts information into database contract string variables
        contentValues.put(DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH, eVideoPath);
        contentValues.put(DatabaseContractVideo.NewDataInfo.COL_TEAM, eTeam);

        //Inserts content values into a specified table in the database
        db.insert(DatabaseContractVideo.NewDataInfo.TABLE_NAME, null, contentValues);

        //Display log message that indicates a row had been added to the database
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    } //End of addInformation

    //This method will get user entered data from the database and return that data to be used elsewhere
    public Cursor getInformation(SQLiteDatabase db){
        //Declares cursor object
        Cursor cursor;

        //Creates string array containing all string values from its respective the database contract
        String[] projections = {DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH, DatabaseContractVideo.NewDataInfo.COL_TEAM};

        //Adds string array of data to the cursor
        cursor = db.query(DatabaseContractVideo.NewDataInfo.TABLE_NAME, projections, null, null, null, null, null);

        //Returns cursor
        return cursor;
    } //End of getInformation

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Required empty constructor
    } //End of onUpgrade
} //End of class
