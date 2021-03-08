package com.myblog.MyBlog.Controllers.Post;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import com.myblog.MyBlog.Blog.DAOandTemplate.Comment;
import com.myblog.MyBlog.Blog.DAOandTemplate.Inscription;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/savepost")
public class SavePostsController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Inscription inscription = getInscriptionFromParameters(request);
            blogDAO.savePost(inscription);
            System.out.println("Udało się zapisać post");
        }
        catch (Exception e){
            System.out.println("Nie udało się zapisać postu");
        }
    response.sendRedirect(request.getContextPath()+"/topics");
    }

    private Inscription getInscriptionFromParameters(HttpServletRequest request) {
        String nick_name = request.getParameter("nick_name");
        String title = request.getParameter("title");
        String inscriptions = request.getParameter("inscriptions");
        int id = blogDAO.getIdInscription();

        return new Inscription(id, nick_name, title, inscriptions);
    }
}