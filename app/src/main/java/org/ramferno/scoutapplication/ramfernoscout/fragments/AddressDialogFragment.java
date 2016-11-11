/**
 * NAME: Samer Alabi
 * CLASS: AddressDialogFragment
 * LAST EDITED: November 9th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class creates an alert dialog object where a user can enter the IP Address that their
 * server is located on.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.AddressProvider;

public class AddressDialogFragment extends DialogFragment {
    //Declare and instantiate objects
    EditText enterIP;

    //Declare and initialize variables
    String ipAddress;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Declare and initialize objects
        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.fragment_dialog, null);
        enterIP = (EditText) v.findViewById(R.id.enterIP);

        //Create AlertDialog
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity())
                //Set title
                .setTitle("Enter IP Address")

                //Set negative button
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Close dialog
                                dialog.cancel();
                            } //End of onClick
                        }) //End of DialogInterface

                //Set positive button
                .setPositiveButton("ADD",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Set IP address to the one entered by the user in the EditText
                                //object
                                ipAddress = enterIP.getText().toString();
                                AddressProvider.getInstance().setAddress(ipAddress);
                            } //End of onClick
                        } //End of DialogInterface
                ); //End of AlertDialog

        //Set view and return the created view
        b.setView(v);
        return b.create();
    } //End of onCreateDialog
} //End of class
