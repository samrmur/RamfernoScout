package org.ramferno.scoutapplication.ramfernoscout.contracts;

public class DatabaseContract {
    public static abstract class NewDataInfo {
        //Declares and initializes table name for database
        public static final String TABLE_NAME = "scout_table";

        //Declares and initializes variables for the table
        public static final String COL_NUMBER = "TEAM_NUMBER";
        public static final String COL_PORTCULLIS = "PORTCULLIS";
        public static final String COL_CHEVAL_FRISE = "CHEVAL_DE_FRISE";
        public static final String COL_MOAT = "MOAT";
        public static final String COL_RAMPARTS = "RAMPARTS";
        public static final String COL_DRAWBRIDGE = "DRAWBRIDGE";
        public static final String COL_SALLY_PORT = "SALLY_PORT";
        public static final String COL_ROCK_WALL = "ROCK_WALL";
        public static final String COL_ROCK_TERRAIN = "ROCK_TERRAIN";
        public static final String COL_LOW_BAR = "LOW_BAR";
        public static final String COL_AUTO_HIGH = "AUTO_HIGH";
        public static final String COL_AUTO_LOW = "AUTO_LOW";
        public static final String COL_TELE_HIGH = "TELE_HIGH";
        public static final String COL_TELE_LOW = "TELE_LOW";
        public static final String COL_TELE_PLAY = "TELE_PLAY";
        public static final String COL_HANG = "HANG";
    } //End of NewDataInfo
} //End of class
