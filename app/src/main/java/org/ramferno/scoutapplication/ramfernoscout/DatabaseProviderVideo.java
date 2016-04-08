package org.ramferno.scoutapplication.ramfernoscout;

public class DatabaseProviderVideo {
    private String videoPath;
    private String team;

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
    } //End of DatabaseProviderMatch
} //End of DatabaseProviderVideo
