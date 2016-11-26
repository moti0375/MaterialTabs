package com.bartovapps.materialtabs.model;

/**
 * Created by BartovMoti on 11/24/16.
 */
public class TextPage extends BasePage {

    private String content;

    public TextPage(String title, String subtitle, String contentType, String content) {
        super(title, subtitle, contentType);

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "content='" + content;
    }
}
