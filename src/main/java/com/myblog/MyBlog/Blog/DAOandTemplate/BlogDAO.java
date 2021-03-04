package com.myblog.MyBlog.Blog.DAOandTemplate;

import com.myblog.MyBlog.Blog.SourceProvider.DataSourceProvider;
import com.myblog.MyBlog.Blog.DAOandTemplate.Users;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    private final DataSource dataSource;

    public BlogDAO(){
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePost (Inscription inscription){
        final String sql = String.format("INSERT INTO inscription (id, title, nick_name, inscritpions) VALUES(?,?,?,?)",
                inscription.getId().toString(), inscription.getTitle(), inscription.getNick_name(), inscription.getInscriptions());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, inscription.getId().toString());
            statement.setString(2, inscription.getTitle());
            statement.setString(3, inscription.getNick_name());
            statement.setString(4, inscription.getInscriptions());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                inscription.setId(generatedKeys.getInt(1));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addUser (Users users){
        final String sql = String.format("INSERT INTO user (id, nick_name, password, age, city) VALUES (?,?,?,?,?)",
                users.getId().toString(), users.getNick_name(), users.getPassword(), users.getAge().toString(), users.getCity());
        final String sql2 = String.format("INSERT INTO user_role (role_name, nick_name) VALUES (?,?)",
                users.getRole_name(), users.getNick_name());
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, (users.getId()).toString());
            statement.setString(2, users.getNick_name());
            statement.setString(3, users.getPassword());
            statement.setString(4, (users.getAge()).toString());
            statement.setString(5, users.getCity());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                users.setId(generatedKeys.getInt(1));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        try (Connection connection2 = dataSource.getConnection();
             PreparedStatement statement = connection2.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, users.getRole_name());
            statement.setString(2, users.getNick_name());
            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Inscription> findAll(){
        final String sql = "SELECT id, nick_name, title, inscritpions FROM inscription";
        List<Inscription> resultList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int inscId = resultSet.getInt("id");
                String inscNick = resultSet.getString("nick_name");
                String title = resultSet.getString("title");
                String inscs = resultSet.getString("inscritpions");

                resultList.add(new Inscription(inscId, inscNick, title, inscs));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public boolean deletePost(int id) {
        final String sql = "DELETE FROM inscription WHERE id = " + id ;
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()){
            int updatedRows = statement.executeUpdate(sql);
            return updatedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> allUsers(){
        final String sql = "SELECT nick_name FROM user";
        List<String> resultList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String inscNick = resultSet.getString("nick_name");
                resultList.add(inscNick);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public Integer getIdUsers(){
        final String sql = "SELECT id FROM user";
        int id = 0;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            return id+1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Integer getIdInscription(){
        final String sql = "SELECT id FROM inscription";
        int id = 0;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            return id+1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveComment (Comment comment){
        final String sql = String.format("INSERT INTO comments (id, nick_name, comment) VALUES(?,?,?)",
                comment.getId().toString(), comment.getNick_name(), comment.getComments());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, comment.getId().toString());
            statement.setString(2, comment.getNick_name());
            statement.setString(3, comment.getComments());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                comment.setId(generatedKeys.getInt(1));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Integer getIdComment(){
        final String sql = "SELECT id FROM comments";
        int id = 0;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            return id+1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}