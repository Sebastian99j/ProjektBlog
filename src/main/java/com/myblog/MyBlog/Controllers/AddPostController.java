package com.myblog.MyBlog.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/addPost")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"user_role", "admin_role"})
)
public class AddPostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/addPost.jsp").forward(request, response);
    }
}
