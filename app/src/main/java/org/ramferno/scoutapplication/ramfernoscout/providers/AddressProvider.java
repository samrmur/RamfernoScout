package org.ramferno.scoutapplication.ramfernoscout.providers;

public class AddressProvider {
    private static AddressProvider ourInstance = new AddressProvider();
    private String ipAddress;

    private AddressProvider() {
        //Required empty constructor
    } //End of AddressProvider

    public static AddressProvider getInstance() {
        return ourInstance;
    } //End of getInstance

    public String getAddress() {
        return ipAddress;
    } //End of getAddress

    public void setAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    } //End of setAddress
} //End of class
