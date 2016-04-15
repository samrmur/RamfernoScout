package org.ramferno.scoutapplication.ramfernoscout;

public class DatabaseProvider {
    private String teamNumber;
    private String portcullis;
    private String chevalFrise;
    private String moat;
    private String ramparts;
    private String drawbridge;
    private String sallyPort;
    private String rockWall;
    private String rockTerrain;
    private String lowBar;
    private String autoHigh;
    private String autoLow;
    private String teleHigh;
    private String teleLow;
    private String telePlay;
    private String hang;

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPortcullis() {
        return portcullis;
    }

    public void setPortcullis(String portcullis) {
        this.portcullis = portcullis;
    }

    public String getMoat() {
        return moat;
    }

    public void setMoat(String moat) {
        this.moat = moat;
    }

    public String getChevalFrise() {
        return chevalFrise;
    }

    public void setChevalFrise(String chevalFrise) {
        this.chevalFrise = chevalFrise;
    }

    public String getRamparts() {
        return ramparts;
    }

    public void setRamparts(String ramparts) {
        this.ramparts = ramparts;
    }

    public String getDrawbridge() {
        return drawbridge;
    }

    public void setDrawbridge(String drawbridge) {
        this.drawbridge = drawbridge;
    }

    public String getSallyPort() {
        return sallyPort;
    }

    public void setSallyPort(String sallyPort) {
        this.sallyPort = sallyPort;
    }

    public String getRockWall() {
        return rockWall;
    }

    public void setRockWall(String rockWall) {
        this.rockWall = rockWall;
    }

    public String getRockTerrain() {
        return rockTerrain;
    }

    public void setRockTerrain(String rockTerrain) {
        this.rockTerrain = rockTerrain;
    }

    public String getLowBar() {
        return lowBar;
    }

    public void setLowBar(String lowBar) {
        this.lowBar = lowBar;
    }

    public String getAutoHigh() {
        return autoHigh;
    }

    public void setAutoHigh(String autoHigh) {
        this.autoHigh = autoHigh;
    }

    public String getAutoLow() {
        return autoLow;
    }

    public void setAutoLow(String autoLow) {
        this.autoLow = autoLow;
    }

    public String getTeleHigh() {
        return teleHigh;
    }

    public void setTeleHigh(String teleHigh) {
        this.teleHigh = teleHigh;
    }

    public String getTeleLow() {
        return teleLow;
    }

    public void setTeleLow(String teleLow) {
        this.teleLow = teleLow;
    }

    public String getTelePlay() {
        return telePlay;
    }

    public void setTelePlay(String telePlay) {
        this.telePlay = telePlay;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public DatabaseProvider(String teamNumber, String portcullis, String chevalFrise, String moat, String ramparts,
                            String drawbridge, String sallyPort, String rockWall, String rockTerrain, String lowBar,
                            String autoHigh, String autoLow, String teleHigh, String teleLow, String telePlay,
                            String hang) {
        this.teamNumber = teamNumber;
        this.portcullis = portcullis;
        this.chevalFrise = chevalFrise;
        this.moat = moat;
        this.ramparts = ramparts;
        this.drawbridge = drawbridge;
        this.sallyPort = sallyPort;
        this.rockWall = rockWall;
        this.rockTerrain = rockTerrain;
        this.lowBar = lowBar;
        this.autoHigh = autoHigh;
        this.autoLow = autoLow;
        this.teleHigh = teleHigh;
        this.teleLow = teleLow;
        this.telePlay = telePlay;
        this.hang = hang;
    } //End of DatabaseProvider
} //End of DatabaseProvider
