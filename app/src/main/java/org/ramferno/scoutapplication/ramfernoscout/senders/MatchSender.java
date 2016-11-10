/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemmy on 3/31/2016 for ProgrammingWizards Channel and Camposha.com
 * CLASS: MatchSender
 * LAST EDITED: November 6th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will attempt to send data from an EditText object that a user has inserted data
 * to the server hosting the database then receive a response determining if the data insertion
 * was successful
 */

//Import packages and all required classes
package org.ramferno.scoutapplication.ramfernoscout.senders;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.connectors.AddConnector;
import org.ramferno.scoutapplication.ramfernoscout.packagers.MatchDataPackager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class MatchSender extends AsyncTask<Void,Void,String> {
    //Declare and initialize variables and objects
    private Context c;
    private String urlAddress;
    private EditText matchNumberTxt, blueTeamOneTxt, blueTeamTwoTxt, blueTeamThreeTxt,
            redTeamOneTxt, redTeamTwoTxt, redTeamThreeTxt, blueScoreTxt, redScoreTxt;
    private int matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne, redTeamTwo,
            redTeamThree, blueScore, redScore;
    private ProgressDialog pd;

    //This constructor will receive the context, url address and the EditText objects from
    //ScoutFragment
    public MatchSender(Context c, String urlAddress, EditText matchNumberTxt,
                       EditText blueTeamOneTxt, EditText blueTeamTwoTxt, EditText blueTeamThreeTxt,
                       EditText redTeamOneTxt, EditText redTeamTwoTxt, EditText redTeamThreeTxt,
                       EditText blueScoreTxt, EditText redScoreTxt) {
        this.c = c;
        this.urlAddress = urlAddress;

        //Store parameter values into class variables
        this.matchNumberTxt = matchNumberTxt;
        this.blueTeamOneTxt = blueTeamOneTxt;
        this.blueTeamTwoTxt = blueTeamTwoTxt;
        this.blueTeamThreeTxt = blueTeamThreeTxt;
        this.redTeamOneTxt = redTeamOneTxt;
        this.redTeamTwoTxt = redTeamTwoTxt;
        this.redTeamThreeTxt = redTeamThreeTxt;
        this.blueScoreTxt = blueScoreTxt;
        this.redScoreTxt = redScoreTxt;

        //Receive data from EditText objects, convert to strings and store them in string variables
        matchNumber = Integer.parseInt(matchNumberTxt.getText().toString());  // Converts to integer
        blueTeamOne = Integer.parseInt(blueTeamOneTxt.getText().toString());
        blueTeamTwo = Integer.parseInt(blueTeamTwoTxt.getText().toString());
        blueTeamThree = Integer.parseInt(blueTeamThreeTxt.getText().toString());
        redTeamOne = Integer.parseInt(redTeamOneTxt.getText().toString());
        redTeamTwo = Integer.parseInt(redTeamTwoTxt.getText().toString());
        redTeamThree = Integer.parseInt(redTeamThreeTxt.getText().toString());
        blueScore = Integer.parseInt(blueScoreTxt.getText().toString());
        redScore = Integer.parseInt(redScoreTxt.getText().toString());
    } //End of ScoutSender

    //Display a message before attempting to send the data to the database
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Send");
        pd.setMessage("Sending..Please wait");
        pd.show();
    } //End of onPreExecute

    //Receive a string with the response on if the data insertion was successful
    @Override
    protected String doInBackground(Void... params) {
        return this.send();
    } //End of doInBackground

    //After attempting to add the data, check string received for response and dismiss PD
    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        pd.dismiss();

        //Check if data insertion was successful or not
        if(response != null)
        {
            //If response contains data, display a message to the user indicating that the data
            //insertion worked
            Toast.makeText(c,"Data insertion successful!",Toast.LENGTH_LONG).show();

            //Reset the variables to default values
            matchNumberTxt.setText("");
            blueTeamOneTxt.setText("");
            blueTeamTwoTxt.setText("");
            blueTeamThreeTxt.setText("");
            redTeamOneTxt.setText("");
            redTeamTwoTxt.setText("");
            redTeamThreeTxt.setText("");
            blueScoreTxt.setText("");
            redScoreTxt.setText("");
        }
        else
        {
            //If response contains no dat, display a message to the user indicating that the data
            //insertion failed
            Toast.makeText(c,"Unsuccessful: " + response,Toast.LENGTH_LONG).show();
        } //End of if statement
    } //End of onPostExecute

    //Send data to the server then receive and return the response
    private String send() {
        //Connect the server
        HttpURLConnection con = AddConnector.connect(urlAddress);

        //Check if connection was successful
        if(con == null)
        {
            return null;
        } //End of if statement
        try
        {
            OutputStream os = con.getOutputStream();

            //Write data to the database on the server
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new MatchDataPackager(matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree,
                    redTeamOne, redTeamTwo, redTeamThree, blueScore,
                    redScore).packData()); //Package data then write to database in server
            bw.flush(); //Flush the BufferedWriter

            //Close OutputStream and BufferedWriter
            bw.close();
            os.close();

            //Check if data was successfully enter into the database
            int responseCode = con.getResponseCode();
            if(responseCode == con.HTTP_OK)
            {
                //Get full response
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response=new StringBuilder();
                String line;

                //Read line by line
                while ((line=br.readLine()) != null)
                {
                    response.append(line);
                }

                //Close BufferedReader and return response as a string
                br.close();
                return response.toString();
            }
        } catch (IOException e) {  //Display error
            e.printStackTrace();
        } //End of try statement
        return null;
    } //End of send
} //End of class