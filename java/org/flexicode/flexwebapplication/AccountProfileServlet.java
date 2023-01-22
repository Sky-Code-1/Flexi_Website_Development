package org.flexicode.flexwebapplication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AccountProfileServlet", value = "/show-profile")
public class AccountProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("logged_in"));
        PrintWriter out = response.getWriter();
        if(session.getAttribute("logged_in") == null) {
            response.sendRedirect("login.jsp");
//            System.out.println("inside if statement");
        }
          else {
            System.out.println("outside the if statement");
            String username = session.getAttribute("username").toString();
            String password = session.getAttribute("password").toString();
            System.out.println(username);
            System.out.println(password);
            FlexiDAO dao = new FlexiDAO();
            System.out.println("About creating a connection");
            FlexiUsers user;
            try {
                System.out.println("inside the try catch block");
                user = dao.getUser(username, password);
                System.out.println("printing user details");
                out.println(user.toString());
            } catch (Exception e) {
                e.toString();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }
}
