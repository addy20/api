package com.aditya.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Response {
    public String status;
    public int total;
    public ArrayList<Article> articleList;

    public static Response parseResponse(JSONObject jsonObject) {
        Response item = new Response();
        item.status = jsonObject.optString("status");
        item.total = jsonObject.optInt("totalResults");
        item.articleList = new ArrayList<>();
        JSONArray articlesArray = jsonObject.optJSONArray("articles");
        if (articlesArray != null && articlesArray.length() > 0) {
            for (int i = 0; i < articlesArray.length(); i++) {
                Article singleArticle = Article.parseResponse(articlesArray.optJSONObject(i));
                item.articleList.add(singleArticle);
            }
        }

        return item;
    }

}
