package org.ramferno.scoutapplication.ramfernoscout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperMatch extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Match.db";
    private static final int DATABASE_VERSION = 2;
    private static final String CREATE_QUERY = "CREATE TABLE " + DatabaseContractMatch.NewDataInfo.TABLE_NAME + "(" +
            DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE + " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE +
            " INTEGER," + DatabaseContractMatch.NewDataInfo.COL_RED_SCORE + " INTEGER);";

    public DatabaseHelperMatch(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Match Database created / opened ...");
    } //End of DatabaseHelperMatch

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Query
        db.execSQL(CREATE_QUERY);

        //Display Log message
        Log.e("DATABASE OPERATIONS", "Match Table created...");
    } //End of onCreate

    public void addInformation(String eMatchNumber, String eBlueTeamOne, String eBlueTeamTwo, String eBlueTeamThree, String eRedTeamOne, String eRedTeamTwo,
                               String eRedTeamThree, String eBlueScore, String eRedScore, SQLiteDatabase db) {
        //Instantiate contentValues
        ContentValues contentValues = new ContentValues();

        //Insert all content values
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER, eMatchNumber);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE, eBlueTeamOne);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO, eBlueTeamTwo);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE, eBlueTeamThree);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE, eRedTeamOne);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO, eRedTeamTwo);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE, eRedTeamThree);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE, eBlueScore);
        contentValues.put(DatabaseContractMatch.NewDataInfo.COL_RED_SCORE, eRedScore);

        //Insert content values into table
        db.insert(DatabaseContractMatch.NewDataInfo.TABLE_NAME, null, contentValues);

        //Display log message
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    } //End of addInformation

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER, DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE,
                DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO, DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE,
                DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE, DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO,
                DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE, DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE,
                DatabaseContractMatch.NewDataInfo.COL_RED_SCORE};
        cursor = db.query(DatabaseContractMatch.NewDataInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    } //End of getInformation

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    } //End of onUpgrade
} //End of class