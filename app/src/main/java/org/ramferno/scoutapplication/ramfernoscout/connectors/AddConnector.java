/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemmy on 3/31/2016 for ProgrammingWizards Channel
 * CLASS: AddConnector
 * LAST EDITED: November 5th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set to
 * them then later on retrieved to be displayed in a ListView.
 */

//Declare package and import classes
package org.ramferno.scoutapplication.ramfernoscout.connectors;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Start of AddConnector
public class AddConnector {
    //Attempt to connect to the database server request for POST
    public static HttpURLConnection connect(String urlAddress) {
        try {
            //Declare and instantiate objects
            URL url=new URL(urlAddress);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            //Set all request properties
            con.setRequestMethod("POST");
            con.setConnectTimeout(20000);
            con.setReadTimeout(20000);
            con.setDoInput(true);
            con.setDoOutput(true);

            //Return con
            return con;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } //End of try statement

        //Return nothing
        return null;
    } //End of HttpURLConnection
} //End of class