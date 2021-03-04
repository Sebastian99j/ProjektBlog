package com.myblog.MyBlog.Controllers.Post;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import com.myblog.MyBlog.Blog.DAOandTemplate.Comment;
import com.myblog.MyBlog.Blog.DAOandTemplate.Inscription;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostsController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Inscription> allPosts = blogDAO.findAll();
        request.setAttribute("posts", allPosts);

        List<Comment> allComment = blogDAO.findAllComment();
        request.setAttribute("comments", allComment);
        request.getRequestDispatcher("WEB-INF/posty.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Inscription inscription = getInscriptionFromParameters(request);
            blogDAO.savePost(inscription);
            System.out.println("Udało się");
        }
        catch (Exception e){
            System.out.println("Nie udało się");
        }
        List<Inscription> allPosts = blogDAO.findAll();
        request.setAttribute("posts", allPosts);

        List<Comment> allComment = blogDAO.findAllComment();
        request.setAttribute("comments", allComment);
        request.getRequestDispatcher("WEB-INF/posty.jsp").forward(request, response);
    }

    private Inscription getInscriptionFromParameters(HttpServletRequest request) {
        String nick_name = request.getParameter("nick_name");
        String title = request.getParameter("title");
        String inscriptions = request.getParameter("inscriptions");
        int id = blogDAO.getIdInscription();

        return new Inscription(id, nick_name, title, inscriptions);
    }
}