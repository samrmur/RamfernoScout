package org.ramferno.scoutapplication.ramfernoscout;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListVideoInfoAdapter extends ArrayAdapter {
    List list = new ArrayList();
    DatabaseHelperVideo databaseHelperVideo = new DatabaseHelperVideo(getContext());

    public ListVideoInfoAdapter (Context context, int resource) {
        super(context, resource);
    } //End of ListVideoInfoAdapter

    static class LayoutHandler {
        TextView TEAM;
        String VIDEO_PATH;
    } //End of LayoutHandler

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    } //End of add

    @Override
    public int getCount() {
        return list.size();
    } //End of getCount

    @Override
    public Object getItem(int position) {
        return list.get(position);
    } //End of getItem

    public void deleteRow(String rowId){
        SQLiteDatabase db = databaseHelperVideo.getWritableDatabase();
        db.delete(DatabaseContractVideo.NewDataInfo.TABLE_NAME,
                DatabaseContractVideo.NewDataInfo.COL_TEAM + "=?",
                new String[] {String.valueOf(rowId)});
    } //End of deleteRow

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final LayoutHandler layoutHandler;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_video, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.TEAM = (TextView) row.findViewById(R.id.resultTeamRecorded);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();
        } //End of if statement
        final DatabaseProviderVideo databaseProviderVideo = (DatabaseProviderVideo) this.getItem(position);
        layoutHandler.TEAM.setText(databaseProviderVideo.getTeam());
        layoutHandler.VIDEO_PATH = databaseProviderVideo.getVideoPath();

        //Plays Video
        Button playBtn = (Button) row.findViewById(R.id.buttonPlayVideo);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri;
                if (layoutHandler.VIDEO_PATH == null) {
                    Toast.makeText(getContext(), "Video file not found", Toast.LENGTH_SHORT).show();
                }
                else {
                    uri = Uri.parse(layoutHandler.VIDEO_PATH);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);
                } //End of if statement
            } //End of onClick
        }); //End of setOnClickListener

        //Deletes ListView row
        Button deleteBtn = (Button) row.findViewById(R.id.buttonDeleteVideo);
        deleteBtn.setTag(databaseProviderVideo.getTeam());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRow((String) v.getTag());
                list.remove(position);
                notifyDataSetChanged();
            } //End of onClick
        }); //End of setOnClickListener
        return row;
    } //End of getView
} //End of ListVideoInfoAdapter
