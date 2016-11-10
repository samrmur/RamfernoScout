package org.ramferno.scoutapplication.ramfernoscout.parsers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.providers.ScoutProvider;
import org.ramferno.scoutapplication.ramfernoscout.adapters.CustomScoutAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class ScoutDataParser extends AsyncTask<Void,Void,Integer>{
    //Declare and instantiate all objects
    private Context c;
    private ListView lv;
    private ProgressDialog pd;
    private ArrayList<ScoutProvider> scoutProvider = new ArrayList<>();

    //Declare and initialize all variables
    private String jsonData;

    public ScoutDataParser(Context c, ListView lv, String jsonData) {
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
            CustomScoutAdapter adapter=new CustomScoutAdapter(c, scoutProvider);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo = null;

            scoutProvider.clear();
            ScoutProvider s = null;

            for(int i=0;i<ja.length();i++)
            {
                jo = ja.getJSONObject(i);

                int id = jo.getInt("id");
                int teamNumber = jo.getInt("teamNumber");
                String portcullis = jo.getString("portcullis");
                String chevalFrise = jo.getString("chevalFrise");
                String moat = jo.getString("moat");
                String ramparts = jo.getString("ramparts");
                String drawbridge = jo.getString("drawbridge");
                String sallyPort = jo.getString("sallyPort");
                String rockWall = jo.getString("rockWall");
                String rockTerrain = jo.getString("rockTerrain");
                String lowBar = jo.getString("lowBar");
                String autoHigh = jo.getString("autoHigh");
                String autoLow = jo.getString("autoLow");
                String teleHigh = jo.getString("teleHigh");
                String teleLow = jo.getString("teleLow");
                String telePlay = jo.getString("telePlay");
                String hang = jo.getString("hang");

                s = new ScoutProvider();
                s.setId(id);
                s.setTeamNumber(teamNumber);
                s.setPortcullis(portcullis);
                s.setChevalFrise(chevalFrise);
                s.setMoat(moat);
                s.setRamparts(ramparts);
                s.setDrawbridge(drawbridge);
                s.setSallyPort(sallyPort);
                s.setRockWall(rockWall);
                s.setRockTerrain(rockTerrain);
                s.setLowBar(lowBar);
                s.setAutoHigh(autoHigh);
                s.setAutoLow(autoLow);
                s.setTeleHigh(teleHigh);
                s.setTeleLow(teleLow);
                s.setTelePlay(telePlay);
                s.setHang(hang);

                scoutProvider.add(s);

            }

            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
