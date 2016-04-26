package org.ramferno.scoutapplication.ramfernoscout.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractMatch;

public class DatabaseHelperMatch extends SQLiteOpenHelper {
    //Declares and initializes all database string variables
    public static final String DATABASE_NAME = "Match.db";
    private static final int DATABASE_VERSION = 2;
    private static final String CREATE_QUERY = "CREATE TABLE " + DatabaseContractMatch.NewDataInfo.TABLE_NAME + "(" +
            DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_SCORE + " INTEGER);";

    public DatabaseHelperMatch(Context context) {
        //Calls on context, the database name and the database version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //Creates log report hat indicates the database has either been created or opened
        Log.e("DATABASE OPERATIONS", "Match Database created / opened ...");
    } //End of DatabaseHelperMatch

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creates query
        db.execSQL(CREATE_QUERY);

        //Displays log message that indicates a table has been created
        Log.e("DATABASE OPERATIONS", "Match Table created...");
    } //End of onCreate

    //This method will add information into the string values in the corresponding database contract
    public void addInformation(String eMatchNumber, String eBlueTeamOne, String eBlueTeamTwo, String eBlueTeamThree, String eRedTeamOne, String eRedTeamTwo,
                               String eRedTeamThree, String eBlueScore, String eRedScore, SQLiteDatabase db) {
        //Declares and instantiates object
        ContentValues contentValues = new ContentValues();

        //Inserts information into database contract string variables
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER, eMatchNumber);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE, eBlueTeamOne);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO, eBlueTeamTwo);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE, eBlueTeamThree);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE, eRedTeamOne);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO, eRedTeamTwo);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE, eRedTeamThree);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE, eBlueScore);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_SCORE, eRedScore);

        //Inserts content values into a specified table in the database
        db.insert(DatabaseContractMatch.NewDataInfo.TABLE_NAME, null, contentValues);

        //Display log message that indicates a row had been added to the database
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    } //End of addInformation

    //This method will get user entered data from the database and return that data to be used elsewhere
    public Cursor getInformation(SQLiteDatabase db){
        //Declares cursor object
        Cursor cursor;

        //Creates string array containing all string values from its respective the database contract
        String[] projections = {DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER, DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE,
                DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO, DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE,
                DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE, DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO,
                DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE, DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE,
                DatabaseContractMatch.NewDataInfo.COL_RED_SCORE};

        //Adds string array of data to the cursor
        cursor = db.query(DatabaseContractMatch.NewDataInfo.TABLE_NAME, projections, null, null, null, null, null);

        //Returns cursor
        return cursor;
    } //End of getInformation

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Required empty constructor
    } //End of onUpgrade
} //End of class