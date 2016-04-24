package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.TeamInfoTabThreeProvider;

import java.util.ArrayList;

public class TabThreeListAdapter extends BaseAdapter {
        private static ArrayList<TeamInfoTabThreeProvider> tabThreeArrayList;

        private LayoutInflater mInflater;

        public TabThreeListAdapter(Context context, ArrayList<TeamInfoTabThreeProvider> results) {
            tabThreeArrayList = results;
            mInflater = LayoutInflater.from(context);
        } //End of TabThreeListAdapter

        public int getCount() {
            return tabThreeArrayList.size();
        } //End of getItem

        public Object getItem(int position) {
            return tabThreeArrayList.get(position);
        } //End of getItem

        public long getItemId(int position) {
            return position;
        } //End of getItemId

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.row_layout_tab_three, null);
                holder = new ViewHolder();
                holder.txtTournamentName = (TextView) convertView.findViewById(R.id.textTournamentName);
                holder.txtYear = (TextView) convertView.findViewById(R.id.textTournamentYear);
                holder.txtRank = (TextView) convertView.findViewById(R.id.textTournamentRank);
                holder.txtRecord = (TextView) convertView.findViewById(R.id.textTournamentRecord);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            } //End of if statement
            holder.txtTournamentName.setText(tabThreeArrayList.get(position).getTournamentName());
            holder.txtYear.setText(tabThreeArrayList.get(position).getYear());
            holder.txtRank.setText(tabThreeArrayList.get(position).getRank());
            holder.txtRecord.setText(tabThreeArrayList.get(position).getRecord());

            return convertView;
        } //End of getView

        static class ViewHolder {
            TextView txtTournamentName;
            TextView txtYear;
            TextView txtRank;
            TextView txtRecord;
        } //End of ViewHolder
} //End of class
