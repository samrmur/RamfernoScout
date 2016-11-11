/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoTabThreeProvider
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will generate all getters and setters for all variables where values will be set
 * to them then later on retrieved to be displayed in a ListView.
 */

//Import package
package org.ramferno.scoutapplication.ramfernoscout.providers;

//Start of DatabaseProviderVideo
public class AddressProvider {
    //Declare and initialize variables
    private static AddressProvider ourInstance = new AddressProvider();
    private String ipAddress;

    private AddressProvider() {
        //Required empty constructor
    } //End of AddressProvider

    //Create only one instance of the Provider so that data values don't change on attempted access
    public static AddressProvider getInstance() {
        return ourInstance;
    } //End of getInstance

    //Generate all getters and setters for all available variables
    public String getAddress() {
        return ipAddress;
    } //End of getAddress

    public void setAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    } //End of setAddress
} //End of class
