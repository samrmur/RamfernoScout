/**
 * NAME: Samer Alabi
 * CLASS: MatchProvider
 * LAST EDITED: November 6th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set
 * to them then later on retrieved to be displayed in a ListView.
 */

//Import package
package org.ramferno.scoutapplication.ramfernoscout.providers;

//Start of ScoutProvider
public class MatchProvider {
    //Declare and initialize variables
    private int id;
    private int matchNumber;
    private int blueTeamOne;
    private int blueTeamTwo;
    private int blueTeamThree;
    private int redTeamOne;
    private int redTeamTwo;
    private int redTeamThree;
    private int blueScore;
    private int redScore;

    //Generate all getters and setters for all available variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getBlueTeamOne() {
        return blueTeamOne;
    }

    public void setBlueTeamOne(int blueTeamOne) {
        this.blueTeamOne = blueTeamOne;
    }

    public int getBlueTeamTwo() {
        return blueTeamTwo;
    }

    public void setBlueTeamTwo(int blueTeamTwo) {
        this.blueTeamTwo = blueTeamTwo;
    }

    public int getBlueTeamThree() {
        return blueTeamThree;
    }

    public void setBlueTeamThree(int blueTeamThree) {
        this.blueTeamThree = blueTeamThree;
    }

    public int getRedTeamOne() {
        return redTeamOne;
    }

    public void setRedTeamOne(int redTeamOne) {
        this.redTeamOne = redTeamOne;
    }

    public int getRedTeamTwo() {
        return redTeamTwo;
    }

    public void setRedTeamTwo(int redTeamTwo) {
        this.redTeamTwo = redTeamTwo;
    }

    public int getRedTeamThree() {
        return redTeamThree;
    }

    public void setRedTeamThree(int redTeamThree) {
        this.redTeamThree = redTeamThree;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public void setBlueScore(int blueScore) {
        this.blueScore = blueScore;
    }

    public int getRedScore() {
        return redScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
    }
} //End of MatchProvider
