package com.bartovapps.materialtabs.model;

/**
 * Created by BartovMoti on 11/24/16.
 */
public abstract class BasePage {

    private String title;
    private String subtitle;
    private String contentType;

    public BasePage(String title, String subtitle, String contentType) {
        this.title = title;
        this.subtitle = subtitle;
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", contentType='" + contentType;
    }
}
