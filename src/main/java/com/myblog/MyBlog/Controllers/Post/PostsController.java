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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("topic");
            List<Inscription> postThis = blogDAO.getPostbyTitle(title);
            request.setAttribute("tytul", title);
            request.setAttribute("thisPost", postThis);
            System.out.println("Udało się");
        }
        catch (Exception e){
            System.out.println("Nie udało się");
        }

        List<Comment> allComment = blogDAO.findAllComment();
        request.setAttribute("comments", allComment);
        request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request, response);
    }
}