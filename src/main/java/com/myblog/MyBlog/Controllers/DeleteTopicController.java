package com.myblog.MyBlog.Controllers;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/deletePost")
public class DeleteTopicController extends HttpServlet {
    final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idKom = request.getParameter("idPost");
        blogDAO.deletePost(Integer.parseInt(idKom));
        response.sendRedirect(request.getContextPath()+"/posts");
    }
}
