/**
 * NAME: Samer Alabi
 * CLASS: DatabaseContractVideo
 * LAST EDITED: November 12th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class puts SQLite database variable names into Java String variables so that they can be
 * accessed by the application itself.
 */

//Import required classes packages and classes
package org.ramferno.scoutapplication.ramfernoscout.contracts;

//Start of Database ContractVideo
public class DatabaseContractVideo {
    public static abstract class NewDataInfo {
        //Declares and initializes table name for database
        public static final String TABLE_NAME = "video_table";

        //Declares and initializes variables for the table
        public static final String COL_VIDEO_PATH = "VIDEO_PATH";
        public static final String COL_TEAM = "TEAM";
    } //End of NewDataInfo
} //End of class
