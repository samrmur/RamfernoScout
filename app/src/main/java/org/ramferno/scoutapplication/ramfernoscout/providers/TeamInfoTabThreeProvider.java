/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoTabThreeProvider
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set
 * to them then later on retrieved to be displayed in a ListView.
 */

//Import required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.providers;

//Start of TeamInfoTabThreeProvider
public class TeamInfoTabThreeProvider {
    //Declare and initialize variables
    private String tournamentName = "";
    private String year = "";
    private String rank = "";
    private String record = "";

    //Generate all getters and setters for all available variables
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRecord() {
        return record;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }
} //End of class
