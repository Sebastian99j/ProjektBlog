package com.myblog.MyBlog.Blog.DAOandTemplate;

public class Comment {
    int id;
    String nick_name;
    String comments;
    int id_inscription;

    public Comment(int id, String nick_name, String comments, int id_inscription) {
        this.id = id;
        this.nick_name = nick_name;
        this.comments = comments;
        this.id_inscription = id_inscription;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }
}
