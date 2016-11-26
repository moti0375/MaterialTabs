package com.bartovapps.materialtabs.model;

/**
 * Created by BartovMoti on 11/24/16.
 */
public class ImagePage extends BasePage {

    private String contentUrl;

    public ImagePage(String title, String subtitle, String contentType, String contentUrl) {
        super(title, subtitle, contentType);

        this.contentUrl = contentUrl;
    }


    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "contentUrl='" + contentUrl;
    }
}
