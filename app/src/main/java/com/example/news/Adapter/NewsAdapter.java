package com.example.news.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.Model.News;
import com.example.news.NewsDesc;
import com.example.news.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    ArrayList<News>myNews;
    Context context;

    public NewsAdapter(ArrayList<News> myNews, Context context) {
        this.myNews = myNews;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_news_list,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        Glide.with(context).load(myNews.get(position).getUrl()).into(holder.mainImg);
        holder.txtNews.setText(myNews.get(position).getMsg());
        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NewsDesc.class);
                intent.putExtra("url",myNews.get(position).getLink());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return myNews.size();
    }

    public  class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView txtNews;
        ImageView imgFav,mainImg;
        CardView newsCard;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsCard = itemView.findViewById(R.id.news_card);
            txtNews = itemView.findViewById(R.id.news_title);
            imgFav = itemView.findViewById(R.id.fav_button);
            mainImg = itemView.findViewById(R.id.news_img);

        }
    }
}