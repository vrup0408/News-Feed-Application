package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.news.Adapter.NewsAdapter;
import com.example.news.Model.News;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    ArrayList<News> myNews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);

        RecyclerView newsRecycle = (RecyclerView)findViewById(R.id.news_recycle);

        NewsApiClient newsApiClient = new NewsApiClient("f3d07795ac8349cead42d6339cd28299");

        // NewsApiClient newsApiClient = new NewsApiClient("96a598d62172446e90ce160c90614715");

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        int size =  response.getArticles().size();
                        for(int i=0; i<size ; i++){
                           myNews.add(new News(response.getArticles().get(i).getTitle().toString(),false,response.getArticles().get(i).getUrlToImage(),response.getArticles().get(i).getUrl()));
                        }

                        newsRecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        newsRecycle.setAdapter(new NewsAdapter(myNews,MainActivity.this));
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}