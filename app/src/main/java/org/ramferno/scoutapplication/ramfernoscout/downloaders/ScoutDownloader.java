/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com
 * CLASS: ScoutDownloader
 * LAST EDITED: November 9th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will download data from the database on the local server.
 */

//Declare package and import classes
package org.ramferno.scoutapplication.ramfernoscout.downloaders;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.connectors.RetrieveConnector;
import org.ramferno.scoutapplication.ramfernoscout.parsers.ScoutDataParser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

//Start of ScoutDownloader
public class ScoutDownloader extends AsyncTask<Void,Void,String> {
    //Declare and instantiate objects
    private Context c;
    private ProgressDialog pd;
    private ListView lv;

    //Declare and initialize variables
    private String urlAddress;

    //Make context, URL Address and ListView equal to the ones provided by the ScoutFragment
    public ScoutDownloader(Context c, String urlAddress, ListView lv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.lv = lv;
    } //End of MatchDownloader

    //Perform before execution of downloadData
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //Display ProgressDialog indicating that the data is being fetched
        pd=new ProgressDialog(c);
        pd.setTitle("Fetch");
        pd.setMessage("Fetching....Please wait");
        pd.show();
    } //End of onPreExecute

    //Perform while downloadData is being executed
    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    } //End of doInBackground

    //Perform after execution of downloadData
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        //Dismiss ProgressDialog that indicates the data is being fetched
        pd.dismiss();

        //Check if connection to server has been made
        if(s == null) {
            Toast.makeText(c,"Unable to connect to server!",Toast.LENGTH_SHORT).show();
        }
        else {
            //Call Data Parser to parse the data before displaying to ListView
            ScoutDataParser parser = new ScoutDataParser(c,lv,s);
            parser.execute();
        } //End of if statement
    } //End of onPostExecute

    //Download the data from the server
    private String downloadData() {
        //Use URl address to connect to the server
        HttpURLConnection con= RetrieveConnector.connect(urlAddress);

        //Return nothing if connection is not established
        if(con == null) {
            return null;
        } //End of if statement

        //Declare and initialize InputStream
        InputStream is = null;

        //Attempt to read the file of data
        try {
            //Declare and instantiate objects
            is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();

            //Declare and initialize variables
            String line;

            //Read all lines of data until the end of the file is reached
            if(br != null) {
                while ((line=br.readLine()) != null) {
                    response.append(line+"\n");
                } //End of while statement

                //Close BufferedReader
                br.close();
            }
            else {
                return null;
            } //End of if statement

            //Return response to Fragment
            return response.toString();
        }
        catch (IOException e) {  //Catch file error
            e.printStackTrace();
        }
        finally {  //Execute if no error has been caught and try block was successful
            if(is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                } //End of try statement
            } //End of if statement
        } //End of try statement

        //Return null
        return null;
    } //End of downloadData
} //End of class