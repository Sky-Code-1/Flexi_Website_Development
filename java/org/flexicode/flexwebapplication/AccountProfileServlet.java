package org.flexicode.flexwebapplication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountProfileServlet", value = "/show-profile")
public class AccountProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getAttribute("username") == null)
            response.sendRedirect("login.jsp");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       FlexiDAO dao = new FlexiDAO();
    }
}
