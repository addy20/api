package com.aditya.api;

public class NewsModel {
    String title,description,source,author,url,urlToImage,publishedAt,content;
    Source sourceValue;

    public NewsModel(String title, String description, String source) {
        this.title = title;
        this.description=description;
        this.source=source;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public Source getSourceValue() {
        return sourceValue;
    }

    public String getTitle() {
        return title;
    }



    public String getDescription() {
        return description;
    }



    public String getSource() {
        return source;
    }
}
