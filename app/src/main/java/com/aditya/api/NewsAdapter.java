package com.aditya.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsListViewHolder>{
     ArrayList<NewsModel> newsList;
     Context context;


    public NewsAdapter(ArrayList<NewsModel> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsListViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder holder, int position) {
    holder.title.setText(newsList.get(position).getTitle());
    holder.description.setText(newsList.get(position).getDescription());
    holder.source.setText(newsList.get(position).getSource());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsListViewHolder extends RecyclerView.ViewHolder{
        private TextView title,description,source;

        public NewsListViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_news);
            description=itemView.findViewById(R.id.description);
            source=itemView.findViewById(R.id.source);
        }
    }
}
