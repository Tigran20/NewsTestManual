package com.example.android.footballnewsapp;


public class Football {

    private String type;
    private String sectionName;
    private String webPublicationDate;
    private String webTitle;
    private String webUrl;

    public Football(String type, String sectionName, String webPublicationDate, String webTitle, String webUrl) {
        this.type = type;
        this.sectionName = sectionName;
        this.webPublicationDate = webPublicationDate;
        this.webTitle = webTitle;
        this.webUrl = webUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getType() {
        return type;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getUrl() {
        return webUrl;
    }
}


