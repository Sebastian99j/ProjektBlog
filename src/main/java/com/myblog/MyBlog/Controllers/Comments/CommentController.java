package com.myblog.MyBlog.Controllers.Comments;

import com.myblog.MyBlog.Blog.DAOandTemplate.BlogDAO;
import com.myblog.MyBlog.Blog.DAOandTemplate.Comment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    private final BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Comment comment = prepareComment(request);
            blogDAO.saveComment(comment);
            System.out.println("Udało się");
        }
        catch (Exception e){
            System.out.println("Nie udało się");
        }
        response.sendRedirect(request.getContextPath()+"/posts");
    }

    private Comment prepareComment(HttpServletRequest request){
        String comment = request.getParameter("kom");
        String nick_name = request.getParameter("nick_name");
        int id = blogDAO.getIdComment();
        String id_inscription = request.getParameter("id_insc");

        return new Comment(id,nick_name, comment, Integer.parseInt(id_inscription));
    }
}
