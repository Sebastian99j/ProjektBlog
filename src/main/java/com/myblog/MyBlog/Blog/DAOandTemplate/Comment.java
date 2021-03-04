package com.myblog.MyBlog.Blog.DAOandTemplate;

public class Comment {
    int id;
    String nick_name;
    String comments;

    public Comment(int id, String nick_name, String comments) {
        this.id = id;
        this.nick_name = nick_name;
        this.comments = comments;
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
}
