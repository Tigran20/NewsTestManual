package com.example.android.footballnewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class FootballLoader extends AsyncTaskLoader<List<Football>> {

    private String url;

    public FootballLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Football> loadInBackground() {
        if (url == null) {
            return null;
        }

        List<Football> news = QueryUtils.fetchNewsData(url);
        return news;
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }
}
