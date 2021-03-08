package com.myblog.MyBlog.Controllers.Post;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import com.myblog.MyBlog.Blog.DAOandTemplate.Comment;
import com.myblog.MyBlog.Blog.DAOandTemplate.Inscription;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/posts")
public class PostsController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("topic");
            List<Inscription> postThis = blogDAO.getPostbyTitle(title);
            request.setAttribute("tytul", title);
            request.setAttribute("thisPost", postThis);
            System.out.println("Udało się wczytać post");
        }
        catch (Exception e){
            System.out.println("Nie udało się wczytać postu");
        }

        List<String> lista = new ArrayList<>();
        request.setAttribute("users", blogDAO.allUsers());

        List<Comment> allComment = blogDAO.findAllComment();
        request.setAttribute("comments", allComment);
        request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Comment comment = prepareComment(request);
            blogDAO.saveComment(comment);
            System.out.println("Udało się dodać komentarz");
        }
        catch (Exception e){
            System.out.println("Nie udało się dodać komentarzu");
        }
        String post_name = request.getParameter("post_name");
        response.sendRedirect(request.getContextPath()+"/posts?topic=" + post_name);
    }

    private Comment prepareComment(HttpServletRequest request){
        String comment = request.getParameter("kom");
        String nick_name = request.getParameter("nick_name");
        int id = blogDAO.getIdComment();
        String id_inscription = request.getParameter("id_insc");

        return new Comment(id,nick_name, comment, Integer.parseInt(id_inscription));
    }
}