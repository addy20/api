package com.aditya.api;

import org.json.JSONObject;

public class Source {
    public String idvalue;
    public String name;

    public static Source parseResponse(JSONObject jsonObject){
        Source item=new Source();
        item.idvalue = jsonObject.optString("id");
        item.name = jsonObject.optString("name");
        return item;
    }
}
