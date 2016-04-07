package org.ramferno.scoutapplication.ramfernoscout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddScoutDataFragment extends Fragment {
    public static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    //URL for spreadsheet
    public static final String URL="https://docs.google.com/forms/d/1L6bVqS357nYk5RAEtPh4Q1qwBJfwXkjkteiMRJHtKSw/formResponse";

    //All spreadsheet entries
    public static final String TEAM_NUMBER_KEY="entry.695204759";
    public static final String PORTCULLIS_KEY="entry.859109466";
    public static final String CHEVAL_FRISE_KEY="entry.1524990324";
    public static final String MOAT_KEY="entry.1572031815";
    public static final String RAMPARTS_KEY="entry.1358934919";
    public static final String DRAWBRIDGE_KEY="entry.1441728213";
    public static final String SALLY_PORT_KEY="entry.1671372604";
    public static final String ROCK_WALL_KEY="entry.1101839915";
    public static final String ROCK_TERRAIN_KEY="entry.431445318";
    public static final String LOW_BAR_KEY="entry.1413521683";

    //Android UI & Database objects
    Button cancelButton;
    Button addDataButton;
    DatabaseHelper myDB;
    EditText tNumber, tPortcullis, tChevalFrise, tMoat, tRamparts, tDrawbridge, tSallyPort, tRockWall, tRockTerrain, tLowBar;
    SQLiteDatabase sqLiteDatabase;

    public AddScoutDataFragment() {
        // Required empty public constructor
    } //End of AddScoutDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_scout_data, container, false);

        //Starts database
        myDB = new DatabaseHelper(getActivity());

        //Instantiate all editText objects
        tNumber = (EditText) view.findViewById(R.id.editNumber);
        tPortcullis = (EditText) view.findViewById(R.id.editPortcullis);
        tChevalFrise = (EditText) view.findViewById(R.id.editChevalFrise);
        tMoat = (EditText) view.findViewById(R.id.editMoat);
        tRamparts = (EditText) view.findViewById(R.id.editRamparts);
        tDrawbridge = (EditText) view.findViewById(R.id.editDrawbridge);
        tSallyPort = (EditText) view.findViewById(R.id.editSallyPort);
        tRockWall = (EditText) view.findViewById(R.id.editRockWall);
        tRockTerrain = (EditText) view.findViewById(R.id.editRockTerrain);
        tLowBar = (EditText) view.findViewById(R.id.editLowBar);

        //Adds data to ScoutFragment
        addDataButton = (Button) view.findViewById(R.id.buttonDataAdd);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Saves data to database
                addScoutInfo();

                //Returns to ScoutFragment
                ScoutFragment fragment = new ScoutFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns to ScoutFragment without adding any data
        cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Returns to ScoutFragment
                ScoutFragment fragment = new ScoutFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    public void addScoutInfo() {
        //Converts all editText values into strings
        String sNumber = tNumber.getText().toString();
        String sPortcullis = tPortcullis.getText().toString();
        String sChevalFrise = tChevalFrise.getText().toString();
        String sMoat = tMoat.getText().toString();
        String sRamparts = tRamparts.getText().toString();
        String sDrawbridge = tDrawbridge.getText().toString();
        String sSallyPort = tSallyPort.getText().toString();
        String sRockWall = tRockWall.getText().toString();
        String sRockTerrain = tRockTerrain.getText().toString();
        String sLowBar = tLowBar.getText().toString();

        //Adds data to Google spreadsheets
        PostDataTask postDataTask = new PostDataTask();
        postDataTask.execute(URL,tNumber.getText().toString(), tPortcullis.getText().toString(), tChevalFrise.getText().toString(),
                tMoat.getText().toString(), tRamparts.getText().toString(), tDrawbridge.getText().toString(), tSallyPort.getText().toString(),
                tRockWall.getText().toString(), tRockTerrain.getText().toString(), tLowBar.getText().toString());

        //Saves data
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sNumber, sPortcullis, sChevalFrise, sMoat, sRamparts, sDrawbridge, sSallyPort, sRockWall,
                sRockTerrain, sLowBar, sqLiteDatabase);
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
        myDB.close();
    } //End of addScoutInfo

    private class PostDataTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String teamNumberKey = contactData[1];
            String portcullisKey = contactData[2];
            String chevalFriseKey = contactData[3];
            String moatKey = contactData[4];
            String rampartsKey = contactData[5];
            String drawbridgeKey = contactData[6];
            String sallyPortKey = contactData[7];
            String rockWallKey = contactData[8];
            String rockTerrainKey = contactData[9];
            String lowBarKey = contactData[10];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = TEAM_NUMBER_KEY +"=" + URLEncoder.encode(teamNumberKey,"UTF-8") +
                        "&" + PORTCULLIS_KEY + "=" + URLEncoder.encode(portcullisKey,"UTF-8") +
                        "&" + CHEVAL_FRISE_KEY + "=" + URLEncoder.encode(chevalFriseKey,"UTF-8") +
                        "&" + MOAT_KEY + "=" + URLEncoder.encode(moatKey,"UTF-8") +
                        "&" + RAMPARTS_KEY + "=" + URLEncoder.encode(rampartsKey,"UTF-8") +
                        "&" + DRAWBRIDGE_KEY + "=" + URLEncoder.encode(drawbridgeKey,"UTF-8") +
                        "&" + SALLY_PORT_KEY + "=" + URLEncoder.encode(sallyPortKey,"UTF-8") +
                        "&" + ROCK_WALL_KEY + "=" + URLEncoder.encode(rockWallKey,"UTF-8") +
                        "&" + ROCK_TERRAIN_KEY + "=" + URLEncoder.encode(rockTerrainKey,"UTF-8") +
                        "&" + LOW_BAR_KEY + "=" + URLEncoder.encode(lowBarKey,"UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result=false;
            } //End of try

            try{
                //Create OkHttpClient for sending request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        } //End of try
    } //End of PostDataTask
} //End of class