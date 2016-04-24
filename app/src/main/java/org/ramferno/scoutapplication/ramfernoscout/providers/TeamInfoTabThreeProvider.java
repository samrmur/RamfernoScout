package org.ramferno.scoutapplication.ramfernoscout.providers;

public class TeamInfoTabThreeProvider {
    private String tournamentName = "";
    private String year = "";
    private String rank = "";
    private String record = "";

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
