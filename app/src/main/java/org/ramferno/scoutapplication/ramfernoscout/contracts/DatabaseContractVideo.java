package org.ramferno.scoutapplication.ramfernoscout.contracts;

public class DatabaseContractVideo {
    public static abstract class NewDataInfo {
        //Declares and initializes table name for database
        public static final String TABLE_NAME = "video_table";

        //Declares and initializes variables for the table
        public static final String COL_VIDEO_PATH = "VIDEO_PATH";
        public static final String COL_TEAM = "TEAM";
    } //End of NewDataInfo
} //End of class
