/**
 * NAME: Samer Alabi
 * CLASS: MatchDataPackager
 * LAST EDITED: November 6th, 2016
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

//Start of MatchDataPackager
public class MatchDataPackager {
    //Declare and initialize variables
    private int matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne, redTeamTwo,
            redTeamThree, blueScore, redScore;

    //Receive all the data that will be sent to the database server
    public MatchDataPackager(int matchNumber, int blueTeamOne, int blueTeamTwo, int blueTeamThree,
                              int redTeamOne, int redTeamTwo, int redTeamThree, int blueScore,
                              int redScore) {
        this.matchNumber = matchNumber;
        this.blueTeamOne = blueTeamOne;
        this.blueTeamTwo = blueTeamTwo;
        this.blueTeamThree = blueTeamThree;
        this.redTeamOne = redTeamOne;
        this.redTeamTwo = redTeamTwo;
        this.redTeamThree = redTeamThree;
        this.blueScore = blueScore;
        this.redScore = redScore;
    }

    //Pack all data into a JSON object, read it, then encode it into a UTC format so that it can be
    //read by the database server
    public String packData() {
        //Declare and instantiate objects
        JSONObject jo = new JSONObject();
        StringBuilder packedData = new StringBuilder();

        //Attempt to data already inserted data into the variables in the database server by name
        try {
            jo.put("matchNumber", matchNumber);
            jo.put("blueTeamOne", blueTeamOne);
            jo.put("blueTeamTwo", blueTeamTwo);
            jo.put("blueTeamThree", blueTeamThree);
            jo.put("redTeamOne", redTeamOne);
            jo.put("redTeamTwo", redTeamTwo);
            jo.put("redTeamThree", redTeamThree);
            jo.put("blueScore", blueScore);
            jo.put("redScore", redScore);
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