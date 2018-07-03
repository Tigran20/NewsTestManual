package com.example.android.footballnewsapp;


public class Football {

    private String type;
    private String section;
    private String date;
    private String title;
    private String url;

    public Football(String typeNews, String sectionName, String newsDate, String webTitle, String Url) {
        type = typeNews;
        section = sectionName;
        date = newsDate;
        title = webTitle;
        url = Url;
    }

    public String getType() {
        return type;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}


