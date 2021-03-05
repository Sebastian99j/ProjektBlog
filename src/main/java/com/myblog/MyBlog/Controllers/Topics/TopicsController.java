package com.myblog.MyBlog.Controllers.Topics;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/topics")
public class TopicsController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> topics = blogDAO.findTopics();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("/WEB-INF/topics.jsp").forward(request, response);
    }
}
