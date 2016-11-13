/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com
 * CLASS: MatchDataParser
 * LAST EDITED: November 12th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will parse JSON data that has been downloaded from a database server. The JSON data
 * will be translated over to regular Java data types then will be transferred over to a data
 * provider where they will be used later on.
 */

//Import required classes packages and classes
package org.ramferno.scoutapplication.ramfernoscout.parsers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.adapters.CustomMatchAdapter;
import org.ramferno.scoutapplication.ramfernoscout.providers.MatchProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//Start of MatchDataParser
public class MatchDataParser extends AsyncTask<Void,Void,Integer>{
    //Declare and instantiate all objects
    private Context c;
    private ListView lv;
    private ProgressDialog pd;
    private ArrayList<MatchProvider> matchProvider = new ArrayList<>();

    //Declare and initialize all variables
    private String jsonData;

    //Set Context, ListView and String to ones that can be accessible by the class
    public MatchDataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
        this.jsonData = jsonData;
    } //End of MatchDataParser

    //Perform before parsing the data
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //Display a ProgressDialog screen indicating that the data is being parsed
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    } //End of onPreExecute

    //Perform while data is being parsed
    @Override
    protected Integer doInBackground(Void... params) {
        //Get a value which helps indicate if the data has been parsed
        return this.parseData();
    } //End of doInBackground

    //Perform after data is parsed
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        //Close the ProgressDialog screen
        pd.dismiss();

        //Check if data has been parsed
        if(result == 0) {
            //If unable parsed, display a message to the user indicating that data was not parsed
            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
        }
        else {
            //If data is parsed, call the adapter to bind the data
            CustomMatchAdapter adapter=new CustomMatchAdapter(c, matchProvider);
            lv.setAdapter(adapter);
        } //End of if statement
    } //End of onPostExecute

    private int parseData() {
        try {
            //Declare and instantiate objects
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            //Clear the provider of any stored data
            matchProvider.clear();
            MatchProvider s;

            for(int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                //Get values from downloaded JSON data
                int id = jo.getInt("id");
                int matchNumber = jo.getInt("matchNumber");
                int blueTeamOne = jo.getInt("blueTeamOne");
                int blueTeamTwo = jo.getInt("blueTeamTwo");
                int blueTeamThree = jo.getInt("blueTeamThree");
                int redTeamOne = jo.getInt("redTeamOne");
                int redTeamTwo = jo.getInt("redTeamTwo");
                int redTeamThree = jo.getInt("redTeamThree");
                int blueScore = jo.getInt("blueScore");
                int redScore = jo.getInt("redScore");

                //Submit all received integer values to the respective provider
                s = new MatchProvider();
                s.setId(id);
                s.setMatchNumber(matchNumber);
                s.setBlueTeamOne(blueTeamOne);
                s.setBlueTeamTwo(blueTeamTwo);
                s.setBlueTeamThree(blueTeamThree);
                s.setRedTeamOne(redTeamOne);
                s.setRedTeamTwo(redTeamTwo);
                s.setRedTeamThree(redTeamThree);
                s.setBlueScore(blueScore);
                s.setRedScore(redScore);

                //Add all parsed data to the provider
                matchProvider.add(s);
            } //End of for loop

            //Return a value of 1 indicating that the data has been parsed
            return 1;
        }
        catch (JSONException e) {
            e.printStackTrace();
        } //End of try statement

        //Return a value of 0 indicating that the data has not been parsed
        return 0;
    } //End of parseData
} //End of class