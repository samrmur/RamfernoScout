package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.TeamInfoTabTwoProvider;

import java.util.ArrayList;

public class TabTwoListAdapter extends BaseAdapter {
    private static ArrayList<TeamInfoTabTwoProvider> tabTwoArrayList;

    private LayoutInflater mInflater;

    public TabTwoListAdapter(Context context, ArrayList<TeamInfoTabTwoProvider> results) {
        tabTwoArrayList = results;
        mInflater = LayoutInflater.from(context);
    } //End of TabThreeListAdapter

    public int getCount() {
        return tabTwoArrayList.size();
    } //End of getItem

    public Object getItem(int position) {
        return tabTwoArrayList.get(position);
    } //End of getItem

    public long getItemId(int position) {
        return position;
    } //End of getItemId

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_layout_tab_two, null);
            holder = new ViewHolder();
            holder.txtAchievementName = (TextView) convertView.findViewById(R.id.textAchievementName);
            holder.txtTournament = (TextView) convertView.findViewById(R.id.textAchievementTourny);
            holder.txtYear = (TextView) convertView.findViewById(R.id.textAchievementYear);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        } //End of if statement
        holder.txtAchievementName.setText(tabTwoArrayList.get(position).getAchievementName());
        holder.txtTournament.setText(tabTwoArrayList.get(position).getTournament());
        holder.txtYear.setText(tabTwoArrayList.get(position).getYear());

        return convertView;
    } //End of getView

    static class ViewHolder {
        TextView txtAchievementName;
        TextView txtTournament;
        TextView txtYear;
    } //End of ViewHolder
} //End of class
