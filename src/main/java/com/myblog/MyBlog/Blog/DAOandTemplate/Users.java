package com.myblog.MyBlog.Blog.DAOandTemplate;

class Users {
    int id;
    String nick_name;
    String password;
    int age;
    String city;
    String role_name = "user_role";

    Users(int id, String nick_name, String password, int age, String city) {
        this.id = id;
        this.nick_name = nick_name;
        this.password = password;
        this.age = age;
        this.city = city;
    }

    Integer getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getNick_name() {
        return nick_name;
    }

    void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    Integer getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
