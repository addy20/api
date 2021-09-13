package com.aditya.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.util.*;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

     RecyclerView recyclerView;
     ArrayList<NewsModel> newsModelArrayList=new ArrayList<>();
     NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNews();


        recyclerView=findViewById(R.id.news_recyclerview);
        //newsModelArrayList.add(new NewsModel("Anything is possible","The growth of the crypto ecosystem is awe-inspiring. Only a year ago, there were around 6,000 currencies on CoinMarketCap.","Dailyfintech.com"));

        newsAdapter=new NewsAdapter(newsModelArrayList,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(newsAdapter);
    }
    public void getNews(){
        ApiInterface apiInterface=ApiClient.getAPIClient().create(ApiInterface.class);

        HashMap<String,String> queries=new HashMap<>();
        queries.put("apiKey","a17ca63eaa8a47e48d01a5accbb7493e");
        queries.put("sources","google-news");

        Call<String> getNews=apiInterface.getAllNews(queries);
        getNews.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("APICALLER","Success");
                Log.e("APICALLER",response.body());
                String responseValue= response.body();
                try {
                    JSONObject jObj=new JSONObject(responseValue);
                    com.aditya.api.Response value= com.aditya.api.Response.parseResponse(jObj);
                    for(int i=0;i<value.articleList.size();i++){
                        Article latest=value.articleList.get(i);
                        newsModelArrayList.add(new NewsModel(latest.titlePage,latest.description,latest.sourceValue.name));
                    }
                    if(newsAdapter!=null){
                        newsAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("APICALLER","Failed");
            }
        });
    }
}