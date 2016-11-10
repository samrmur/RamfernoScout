package org.ramferno.scoutapplication.ramfernoscout.parsers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.adapters.CustomMatchAdapter;
import org.ramferno.scoutapplication.ramfernoscout.providers.MatchProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MatchDataParser extends AsyncTask<Void,Void,Integer>{
    //Declare and instantiate all objects
    private Context c;
    private ListView lv;
    private ProgressDialog pd;
    private ArrayList<MatchProvider> matchProvider = new ArrayList<>();

    //Declare and initialize all variables
    private String jsonData;

    public MatchDataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result==0)
        {
            Toast.makeText(c,"Unable to parse",Toast.LENGTH_SHORT).show();
        }else {
            //CALL ADAPTER TO BIND DATA
            CustomMatchAdapter adapter=new CustomMatchAdapter(c, matchProvider);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            matchProvider.clear();
            MatchProvider s;

            for(int i=0;i<ja.length();i++) {
                jo = ja.getJSONObject(i);

                int id = jo.getInt("id");
                int matchNumber = jo.getInt("matchNumber");
                int blueTeamOne = jo.getInt("blueTeamOne");
                int blueTeamTwo = jo.getInt("blueTeamTwo");
                int blueTeamThree = jo.getInt("blueTeamThree");
                int redTeamOne = jo.getInt("redTeamOne");
                int redTeamTwo = jo.getInt("redTeamTwo");
                int redTeamThree = jo.getInt("redTeamThree");
                int blueScore = jo.getInt("blueScore");
                int redScore = jo.getInt("redScore");

                s = new MatchProvider();
                s.setId(id);
                s.setMatchNumber(matchNumber);
                s.setBlueTeamOne(blueTeamOne);
                s.setBlueTeamTwo(blueTeamTwo);
                s.setBlueTeamThree(blueTeamThree);
                s.setRedTeamOne(redTeamOne);
                s.setRedTeamTwo(redTeamTwo);
                s.setRedTeamThree(redTeamThree);
                s.setBlueScore(blueScore);
                s.setRedScore(redScore);

                matchProvider.add(s);
            }
            return 1;
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}