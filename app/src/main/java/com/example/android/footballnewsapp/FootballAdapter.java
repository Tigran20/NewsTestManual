package com.example.android.footballnewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FootballAdapter extends ArrayAdapter<Football> {

    public FootballAdapter(Context context, ArrayList<Football> allFootball) {
        super(context, 0, allFootball);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.football_list_item, parent, false);
        }

        Football currentFootball = getItem(position);

        TextView typeView = listItemView.findViewById(R.id.type_tv);
        TextView sectionView = listItemView.findViewById(R.id.section_tv);
        TextView titleView = listItemView.findViewById(R.id.title_tv);
        TextView dateView = listItemView.findViewById(R.id.date_tv);

        String type = String.valueOf(currentFootball.getType());
        String sectionName = String.valueOf(currentFootball.getSectionName());
        String title = String.valueOf(currentFootball.getWebTitle());
        String date = String.valueOf(currentFootball.getWebPublicationDate());

        typeView.setText(type);
        sectionView.setText(sectionName);
        titleView.setText(title);
        dateView.setText(date);

        return listItemView;

    }

}
