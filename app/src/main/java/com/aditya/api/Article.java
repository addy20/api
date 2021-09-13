package com.aditya.api;

import org.json.JSONObject;

public class Article {
    public String author;
    public String titlePage;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
    public Source sourceValue;

    public static Article parseResponse(JSONObject jsonObject){
        Article item = new Article();
        item.author = jsonObject.optString("author");
        item.titlePage = jsonObject.optString("title");
        item.description=jsonObject.optString("description");
        item.url=jsonObject.optString("url");
        item.urlToImage=jsonObject.optString("urlToImage");
        item.publishedAt=jsonObject.optString("publishedAt");
        item.content=jsonObject.optString("content");
        item.sourceValue =Source.parseResponse(jsonObject.optJSONObject("source"));
        return item;
    }
}
