/**
 * NAME: Samer Alabi
 * CLASS: MainActivity
 * LAST EDITED: November 5th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class is the main function of the application. It contains the navigation menu
 * instructions that is used to switch between the main fragments of the application.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout;

import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.fragments.AddressDialogFragment;
import org.ramferno.scoutapplication.ramfernoscout.fragments.MatchFragment;
import org.ramferno.scoutapplication.ramfernoscout.fragments.ScoutFragment;
import org.ramferno.scoutapplication.ramfernoscout.fragments.TeamInfoFragment;
import org.ramferno.scoutapplication.ramfernoscout.fragments.VideoFragment;
import org.ramferno.scoutapplication.ramfernoscout.fragments.WelcomeFragment;

//Start of MainActivity
public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    //Declares Android UI objects
    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Disables Orientation throughout the entire application
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Opens initial fragment
        WelcomeFragment fragment = new WelcomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Change elements in the header programmatically
        View headerView = navigationView.getHeaderView(0);
        TextView emailText = (TextView) headerView.findViewById(R.id.description);
        emailText.setText("Scouting Application");

        navigationView.setNavigationItemSelectedListener(this);
    } //End of onCreate

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        } //End of if statement
    } //End of onBackPressed

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Handle navigation view item clicks here.
        int id = item.getItemId();

        //Switch to fragment on item select
        if (id == R.id.nav_welcome) {
            WelcomeFragment fragment = new WelcomeFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_teamInfo) {
            TeamInfoFragment fragment = new TeamInfoFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_scout) {
            ScoutFragment fragment = new ScoutFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_match) {
            MatchFragment fragment = new MatchFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_video) {
            VideoFragment fragment = new VideoFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } //End of if statement

        //Close Drawer after use
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    } //End of onNavigationItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    } //End of onCreateOptionMenu

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                FragmentManager fm = getFragmentManager();
                AddressDialogFragment dialogFragment = new AddressDialogFragment();
                dialogFragment.show(fm, "Sample Fragment");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
} //End of class