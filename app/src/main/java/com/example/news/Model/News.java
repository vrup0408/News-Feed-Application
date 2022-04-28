package com.example.news.Model;

public class News {

    String msg,url,link;
    boolean fav;

    public News(String msg, boolean fav,String url,String link) {
        this.msg = msg;
        this.fav = fav;
        this.url = url;
        this.link = link;
    }
    News(){}

    public String getMsg() {
        return msg;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
