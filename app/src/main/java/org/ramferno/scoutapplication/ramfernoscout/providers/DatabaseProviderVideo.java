/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoTabThreeProvider
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set
 * to them then later on retrieved to be displayed in a ListView.
 */

//Import package
package org.ramferno.scoutapplication.ramfernoscout.providers;

//Start of DatabaseProviderVideo
public class DatabaseProviderVideo {
    //Declare and initialize variables
    private String videoPath;
    private String team;

    //Generate all getters and setters for all available variables
    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public DatabaseProviderVideo(String videoPath, String team) {
        this.videoPath = videoPath;
        this.team = team;
    } //End of DatabaseProviderVideo
} //End of class
