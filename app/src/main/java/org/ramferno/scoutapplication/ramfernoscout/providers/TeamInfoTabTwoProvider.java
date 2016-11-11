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

//Start of TeamInfoTabTwoProvider
public class TeamInfoTabTwoProvider {
    //Declare and initialize variables
    private String achievementName = "";
    private String tournament = "";
    private String year = "";

    //Generate all getters and setters for all available variables
    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }
} //End of class
