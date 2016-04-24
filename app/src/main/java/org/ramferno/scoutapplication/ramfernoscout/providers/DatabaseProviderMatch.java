package org.ramferno.scoutapplication.ramfernoscout.providers;

public class DatabaseProviderMatch {
    private String matchNumber;
    private String blueTeamOne;
    private String blueTeamTwo;
    private String blueTeamThree;
    private String redTeamOne;
    private String redTeamTwo;
    private String redTeamThree;
    private String blueScore;
    private String redScore;

    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getBlueTeamOne() {
        return blueTeamOne;
    }

    public void setBlueTeamOne(String blueTeamOne) {
        this.blueTeamOne = blueTeamOne;
    }

    public String getBlueTeamTwo() {
        return blueTeamTwo;
    }

    public void setBlueTeamTwo(String blueTeamTwo) {
        this.blueTeamTwo = blueTeamTwo;
    }

    public String getBlueTeamThree() {
        return blueTeamThree;
    }

    public void setBlueTeamThree(String blueTeamThree) {
        this.blueTeamThree = blueTeamThree;
    }

    public String getRedTeamOne() {
        return redTeamOne;
    }

    public void setRedTeamOne(String redTeamOne) {
        this.redTeamOne = redTeamOne;
    }

    public String getRedTeamTwo() {
        return redTeamTwo;
    }

    public void setRedTeamTwo(String redTeamTwo) {
        this.redTeamTwo = redTeamTwo;
    }

    public String getRedTeamThree() {
        return redTeamThree;
    }

    public void setRedTeamThree(String redTeamThree) {
        this.redTeamThree = redTeamThree;
    }

    public String getBlueScore() {
        return blueScore;
    }

    public void setBlueScore(String blueScore) {
        this.blueScore = blueScore;
    }

    public String getRedScore() {
        return redScore;
    }

    public void setRedScore(String redScore) {
        this.redScore = redScore;
    }

    public DatabaseProviderMatch(String matchNumber, String blueTeamOne, String blueTeamTwo, String blueTeamThree, String redTeamOne,String redTeamTwo,
                                 String redTeamThree, String blueScore, String redScore) {
        this.matchNumber = matchNumber;
        this.blueTeamOne = blueTeamOne;
        this.blueTeamTwo = blueTeamTwo;
        this.blueTeamThree = blueTeamThree;
        this.redTeamOne = redTeamOne;
        this.redTeamTwo = redTeamTwo;
        this.redTeamThree = redTeamThree;
        this.blueScore = blueScore;
        this.redScore = redScore;
    } //End of DatabaseProviderMatch
} //End of DatabaseProviderMatch
