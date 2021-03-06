/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoTabOneFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class contains instructions for all objects placed within the first tab created by the
 * tab layout in TeamInfoFragment. The class uses a ViewFlipper objects and makes a slideshow
 * with using multiple different images. This class also connects the user to team-related web
 * pages on specific button clicks.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import org.ramferno.scoutapplication.ramfernoscout.R;

//Start of TeamInfoTabOneFragment
public class TeamInfoTabOneFragment extends Fragment {
   //Declares Android UI objects
    ViewFlipper viewFlipper;
    Button openWebsite, likeFB, followTwit;

    public TeamInfoTabOneFragment() {
        // Required empty public constructor
    } //End of TeamInfoTabOneFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for the fragment
        View view =  inflater.inflate(R.layout.fragment_team_info_tab_one, container, false);

        //Create array of images for VIewFlipper
        int gallery_grid_Images[] = {R.drawable.galleryimage1, R.drawable.galleryimage2,
                R.drawable.galleryimage3, R.drawable.galleryimage4, R.drawable.galleryimage5,
                R.drawable.galleryimage6, R.drawable.galleryimage7, R.drawable.galleryimage8};

        //Declare ViewFlipper and connect it to corresponding xml object
        viewFlipper = (ViewFlipper) view.findViewById(R.id.flipperTeamImages);

        //Removes blank ViewFlipper view
        viewFlipper.removeAllViews();

        //Adds Image Array into ViewFlipper
        for(int i = 0; i < gallery_grid_Images.length; i++) {
            setFlipperImage(gallery_grid_Images[i]);
        } //End of for statement

        //Starts the ViewFlipper
        viewFlipper.setAutoStart(true);

        //Animates the ViewFlipper between images
        viewFlipper.setInAnimation(getContext(), R.anim.fade_in);
        viewFlipper.setOutAnimation(getContext(), R.anim.fade_out);

        //Switches images every 2 seconds
        viewFlipper.setFlipInterval(2000);

        //Starts flipping the ViewFlipper
        viewFlipper.startFlipping();

        //Opens team website on button click
        openWebsite = (Button) view.findViewById(R.id.buttonWebsite);
        openWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.ramferno.org/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } //End of onClick
        }); //End of setOnClickListener

        //Opens facebook page on button click
        likeFB = (Button) view.findViewById(R.id.buttonLikeFB);
        likeFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.facebook.com/3756RamFerno/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } //End of onClick
        }); //End of setOnClickListener

        //Opens twitter page on button click
        followTwit = (Button) view.findViewById(R.id.buttonFollowTwit);
        followTwit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.twitter.com/3756ramferno/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } //End of onClick
        }); //End of setOnClickListener

        //Returns the view to the Fragment
        return view;
    } //End of onCreateView

    //Sets ImageView's resource to main resource folder and adds ImageView to the ViewFlipper
    private void setFlipperImage(int res) {
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
    } //End of setFlipperImage
} //End of class