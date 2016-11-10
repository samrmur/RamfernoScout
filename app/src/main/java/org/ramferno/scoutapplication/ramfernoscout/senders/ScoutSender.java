/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemmy on 3/31/2016 for ProgrammingWizards Channel and Camposha.com
 * CLASS: ScoutSender
 * LAST EDITED: November 4th, 2016
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
import org.ramferno.scoutapplication.ramfernoscout.packagers.ScoutDataPackager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class ScoutSender extends AsyncTask<Void,Void,String> {
    //Declare and initialize variables and objects
    private Context c;
    private String urlAddress;
    private EditText teamNumberTxt, telePlayTxt;
    private int teamNumber;
    private String portcullis, chevalFrise, moat, ramparts, drawbridge, sallyPort, rockWall,
            rockTerrain, lowBar, autoHigh, autoLow, teleHigh, teleLow, telePlay, hang;
    private ProgressDialog pd;

    //This constructor will receive the context, url address and the EditText objects from
    //ScoutFragment
    public ScoutSender(Context c, String urlAddress, EditText teamNumberTxt, String portcullis,
                       String chevalFrise, String moat, String ramparts, String drawbridge,
                       String sallyPort, String rockWall, String rockTerrain, String lowBar,
                       String autoHigh, String autoLow, String teleHigh, String teleLow,
                       EditText telePlayTxt, String hang) {
        this.c = c;
        this.urlAddress = urlAddress;

        //Store parameter values into class variables
        this.teamNumberTxt = teamNumberTxt;
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
        this.telePlayTxt = telePlayTxt;
        this.hang = hang;

        //Receive data from EditText objects, convert to strings and store them in string variables
        teamNumber = Integer.parseInt(teamNumberTxt.getText().toString());  // Converts to integer
        telePlay = telePlayTxt.getText().toString();
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
            teamNumberTxt.setText("");
            portcullis = "";
            chevalFrise = "";
            moat = "";
            ramparts = "";
            drawbridge = "";
            sallyPort = "";
            rockWall = "";
            rockTerrain = "";
            lowBar = "";
            autoHigh = "";
            autoLow = "";
            teleHigh = "";
            teleLow =  "";
            telePlayTxt.setText("");
            hang = "";
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
            bw.write(new ScoutDataPackager(teamNumber, portcullis, chevalFrise, moat, ramparts,
                    drawbridge, sallyPort, rockWall, rockTerrain, lowBar, autoHigh, autoLow,
                    teleHigh, teleLow, telePlay,
                    hang).packData()); //Package data then write to database in server
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
