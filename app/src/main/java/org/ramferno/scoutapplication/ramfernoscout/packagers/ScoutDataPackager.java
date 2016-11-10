/**
 * NAME: Samer Alabi
 * CLASS: ScoutDataPackager
 * LAST EDITED: November 5th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will package all data that will data being sent to the database server by encoding
 * all the data in a UTC format then putting them all into a JSON object
 */

//Import packages and classes
package org.ramferno.scoutapplication.ramfernoscout.packagers;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

//Start of ScoutDataPackager
public class ScoutDataPackager {
    //Declare and initialize variables
    private int teamNumber;
    private String portcullis, chevalFrise, moat, ramparts, drawbridge, sallyPort, rockWall,
            rockTerrain, lowBar, autoHigh, autoLow, teleHigh, teleLow, telePlay, hang;

    //Receive all the data that will be sent to the database server
    public ScoutDataPackager(int teamNumber, String portcullis, String chevalFrise, String moat,
                             String ramparts, String drawbridge, String sallyPort, String rockWall,
                             String rockTerrain, String lowBar, String autoHigh, String autoLow,
                             String teleHigh, String teleLow, String telePlay, String hang) {
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
    } //End of ScoutDataPackager

    //Pack all data into a JSON object, read it, then encode it into a UTC format so that it can be
    //read by the database server
    public String packData() {
        //Declare and instantiate objects
        JSONObject jo = new JSONObject();
        StringBuilder packedData = new StringBuilder();

        //Attempt to data already inserted data into the variables in the database server by name
        try {
            jo.put("teamNumber", teamNumber);
            jo.put("portcullis", portcullis);
            jo.put("chevalFrise", chevalFrise);
            jo.put("moat", moat);
            jo.put("ramparts", ramparts);
            jo.put("drawbridge", drawbridge);
            jo.put("sallyPort", sallyPort);
            jo.put("rockWall", rockWall);
            jo.put("rockTerrain", rockTerrain);
            jo.put("lowBar", lowBar);
            jo.put("autoHigh", autoHigh);
            jo.put("autoLow", autoLow);
            jo.put("teleHigh", teleHigh);
            jo.put("teleLow", teleLow);
            jo.put("telePlay", telePlay);
            jo.put("hang", hang);
            Boolean firstValue=true;
            Iterator it=jo.keys();
            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();
                if(firstValue) {
                    firstValue=false;
                }
                else {
                    packedData.append("&");
                }
                packedData.append(URLEncoder.encode(key,"UTF-8"));
                packedData.append("=");
                packedData.append(URLEncoder.encode(value,"UTF-8"));
            } while (it.hasNext());
            return packedData.toString();
        } //End of do statement
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } //End of try statement

        //Return nothing
        return null;
    } //End of packData
} //End of class