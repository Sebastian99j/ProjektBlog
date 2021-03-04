package com.myblog.MyBlog.Controllers;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<String> lista = new ArrayList<>();
            request.setAttribute("users", blogDAO.allUsers());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
