package com.example.android.footballnewsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FootballActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Football>> {


    private static final int NEWS_LOADER_ID = 1;
    private static final String GUARDIAN_REQUEST_URL =
            "https://content.guardianapis.com/football?api-key=14153493-2fcc-42d8-9cc6-5a202222e671";

    private FootballAdapter adapter;
    private FootballLoader loader;

    private TextView emptyStateTextView;
    private ListView footballListView;
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football_activity);

        footballListView = findViewById(R.id.list);
        emptyStateTextView = findViewById(R.id.empty_view);
        footballListView.setEmptyView(emptyStateTextView);

        adapter = new FootballAdapter(this, new ArrayList<Football>());
        footballListView.setAdapter(adapter);

        connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            emptyStateTextView.setText(R.string.no_internet_connection);
        }

        footballListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Football currentNews = adapter.getItem(position);
                Uri newsUri = Uri.parse(currentNews.getWebUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);
            }
        });

        loader = (FootballLoader) getLoaderManager().initLoader(NEWS_LOADER_ID, null, this);
    }

    @Override
    public Loader<List<Football>> onCreateLoader(int i, Bundle bundle) {
        return new FootballLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Football>> loader, List<Football> footballs) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        emptyStateTextView.setText(R.string.no_news);

        adapter.clear();

        if (footballs != null && !footballs.isEmpty()) {
            adapter.addAll(footballs);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Football>> loader) {
        adapter.clear();
    }

}
