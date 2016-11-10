/**
 * NAME: Samer Alabi
 * CLASS: ScoutProvider
 * LAST EDITED: November 5th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set
 * to them then later on retrieved to be displayed in a ListView.
 */

//Declare package
package org.ramferno.scoutapplication.ramfernoscout.providers;

//Start of ScoutProvider
public class ScoutProvider {
    //Declare and initialize variables
    private int id;
    private int teamNumber;
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

    //Generate all getters and setters for all available variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
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
} //End of class