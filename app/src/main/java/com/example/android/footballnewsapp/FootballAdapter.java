package com.example.android.footballnewsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@link FootballAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link Football} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */

public class FootballAdapter extends ArrayAdapter<Football> {



    public FootballAdapter(Context context, List<Football> allFootball) {
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
        typeView.setText(currentFootball.getType());

        TextView sectionView = listItemView.findViewById(R.id.section_tv);
        sectionView.setText(currentFootball.getSection());

        TextView titleView = listItemView.findViewById(R.id.title_tv);
        titleView.setText(currentFootball.getTitle());

        TextView dateView = listItemView.findViewById(R.id.date_tv);
        dateView.setText(currentFootball.getDate());

        return listItemView;

    }

}
