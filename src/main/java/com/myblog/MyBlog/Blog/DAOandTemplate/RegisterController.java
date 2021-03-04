package com.myblog.MyBlog.Blog.DAOandTemplate;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import com.myblog.MyBlog.Blog.DAOandTemplate.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Users user = getUsersByParameter(request);
            blogDAO.addUser(user);
            System.out.println("Udało się!");
        }
        catch (Exception e){
            System.out.println("Nie udało się!");
        }
        response.sendRedirect(request.getContextPath());
    }

    private Users getUsersByParameter (HttpServletRequest request){
        String nick_name = request.getParameter("nick_name_u");
        String password = request.getParameter("password_u");
        String age = request.getParameter("age_u");
        String city = request.getParameter("city_u");
        int id = blogDAO.getIdUsers();

        return new Users(id, nick_name, password, Integer.parseInt(age), city);
    }
}
