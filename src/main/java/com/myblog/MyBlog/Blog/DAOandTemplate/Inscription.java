package com.myblog.MyBlog.Blog.DAOandTemplate;

public class Inscription {
        int id;
        String nick_name;
        String title;
        String inscriptions;

    public Inscription(int id, String nick_name, String title, String inscriptions) {
        this.id = id;
        this.nick_name = nick_name;
        this.title = title;
        this.inscriptions = inscriptions;
    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(String inscriptions) {
        this.inscriptions = inscriptions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
