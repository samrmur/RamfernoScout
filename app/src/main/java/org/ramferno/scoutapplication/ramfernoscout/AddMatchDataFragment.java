package org.ramferno.scoutapplication.ramfernoscout;

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
public class AddMatchDataFragment extends Fragment {
    public static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    //URL for spreadsheet
    public static final String URL="https://docs.google.com/forms/d/1Jr0XgDizvMOaXvq1M69b9M8D-FCQYs0ZsFzyEulEc4Q/formResponse";

    //All spreadsheet entries
    public static final String MATCH_NUMBER_KEY = "entry.1496750321";
    public static final String BLUE_TEAM_ONE_KEY = "entry.23710236";
    public static final String BLUE_TEAM_TWO_KEY = "entry.1638093641";
    public static final String BLUE_TEAM_THREE_KEY = "entry.1830867471";
    public static final String BLUE_SCORE_KEY = "entry.1318761187";
    public static final String RED_TEAM_ONE_KEY = "entry.164453406";
    public static final String RED_TEAM_TWO_KEY = "entry.995887859";
    public static final String RED_TEAM_THREE_KEY = "entry.752011238";
    public static final String RED_SCORE_KEY = "entry.1696671939";

    //Android UI & Database objects
    Button cancelButtonMatch;
    Button addMatchButton;
    DatabaseHelperMatch myDB;
    EditText tMatchNumber, tBlueTeamOne, tBlueTeamTwo, tBlueTeamThree, tRedTeamOne, tRedTeamTwo, tRedTeamThree, tBlueScore, tRedScore;
    SQLiteDatabase sqLiteDatabase;

    public AddMatchDataFragment() {
        // Required empty public constructor
    } //End of AddMatchDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_match_data, container, false);

        //Starts database
        myDB = new DatabaseHelperMatch(getActivity());

        //Instantiate all editText objects
        tMatchNumber = (EditText) view.findViewById(R.id.editNumberMatch);
        tBlueTeamOne = (EditText) view.findViewById(R.id.editBlueOne);
        tBlueTeamTwo = (EditText) view.findViewById(R.id.editBlueTwo);
        tBlueTeamThree = (EditText) view.findViewById(R.id.editBlueThree);
        tRedTeamOne = (EditText) view.findViewById(R.id.editRedOne);
        tRedTeamTwo = (EditText) view.findViewById(R.id.editRedTwo);
        tRedTeamThree = (EditText) view.findViewById(R.id.editRedThree);
        tBlueScore = (EditText) view.findViewById(R.id.editBlueScore);
        tRedScore = (EditText) view.findViewById(R.id.editRedScore);

        //Adds data to MatchFragment
        addMatchButton = (Button) view.findViewById(R.id.buttonAddDataMatch);
        addMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Saves data to database
                addMatchInfo();

                //Returns to MatchFragment
                MatchFragment fragment = new MatchFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns to MatchFragment without adding any data
        cancelButtonMatch = (Button) view.findViewById(R.id.buttonCancelMatch);
        cancelButtonMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Returns to MatchFragment
                MatchFragment fragment = new MatchFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    public void addMatchInfo() {
        //Converts all editText values into strings
        String sMatchNumber = tMatchNumber.getText().toString();
        String sBlueTeamOne = tBlueTeamOne.getText().toString();
        String sBlueTeamTwo = tBlueTeamTwo.getText().toString();
        String sBlueTeamThree = tBlueTeamThree.getText().toString();
        String sRedTeamOne = tRedTeamOne.getText().toString();
        String sRedTeamTwo = tRedTeamTwo.getText().toString();
        String sRedTeamThree = tRedTeamThree.getText().toString();
        String sBlueScore = tBlueScore.getText().toString();
        String sRedScore = tRedScore.getText().toString();

        //Adds data to Google spreadsheets
        PostDataTask postDataTask = new PostDataTask();
        postDataTask.execute(URL,tMatchNumber.getText().toString(), tBlueTeamOne.getText().toString(), tBlueTeamTwo.getText().toString(),
                tBlueTeamThree.getText().toString(), tBlueScore.getText().toString(), tRedTeamOne.getText().toString(), tRedTeamTwo.getText().toString(),
                tRedTeamThree.getText().toString(), tRedScore.getText().toString());

        //Saves data
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sMatchNumber, sBlueTeamOne, sBlueTeamTwo, sBlueTeamThree, sRedTeamOne, sRedTeamTwo, sRedTeamThree, sBlueScore,
                sRedScore, sqLiteDatabase);
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
        myDB.close();
    } //End of addScoutInfo

    private class PostDataTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String matchNumberKey = contactData[1];
            String blueTeamOneKey = contactData[2];
            String blueTeamTwoKey = contactData[3];
            String blueTeamThreeKey = contactData[4];
            String blueScoreKey = contactData[5];
            String redTeamOneKey = contactData[6];
            String redTeamTwoKey = contactData[7];
            String redTeamThreeKey = contactData[8];
            String redScoreKey = contactData[9];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = MATCH_NUMBER_KEY +"=" + URLEncoder.encode(matchNumberKey, "UTF-8") +
                        "&" + BLUE_TEAM_ONE_KEY + "=" + URLEncoder.encode(blueTeamOneKey,"UTF-8") +
                        "&" + BLUE_TEAM_TWO_KEY + "=" + URLEncoder.encode(blueTeamTwoKey,"UTF-8") +
                        "&" + BLUE_TEAM_THREE_KEY + "=" + URLEncoder.encode(blueTeamThreeKey,"UTF-8") +
                        "&" + BLUE_SCORE_KEY + "=" + URLEncoder.encode(blueScoreKey,"UTF-8") +
                        "&" + RED_TEAM_ONE_KEY + "=" + URLEncoder.encode(redTeamOneKey,"UTF-8") +
                        "&" + RED_TEAM_TWO_KEY + "=" + URLEncoder.encode(redTeamTwoKey,"UTF-8") +
                        "&" + RED_TEAM_THREE_KEY + "=" + URLEncoder.encode(redTeamThreeKey,"UTF-8") +
                        "&" + RED_SCORE_KEY + "=" + URLEncoder.encode(redScoreKey,"UTF-8");
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