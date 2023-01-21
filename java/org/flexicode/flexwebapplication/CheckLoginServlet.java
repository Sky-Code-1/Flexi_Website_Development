package org.flexicode.flexwebapplication;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "CheckLoginServlet", value = "/check-login")
public class CheckLoginServlet extends HttpServlet {
    boolean loggedIn;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          RequestDispatcher rdSuccess = request.getRequestDispatcher("welcome-home.jsp");
          RequestDispatcher rdFailed = request.getRequestDispatcher("login.jsp");
          try{
              if(createConnection(username,password)) {
                  loggedIn = true;
                  request.setAttribute("logged_in", loggedIn);
                  request.setAttribute("username", username);
                  request.setAttribute("password",password);
                  rdSuccess.forward(request,response);
              }
              else
                  rdFailed.forward(request,response);
          }
              catch (Exception e){
                  System.out.println(e.toString());
              }
    }

    /**
     * This method takes in two parameters of type string as seen below
     * @param name is the name of the user that is login in into the page
     * @param pass is the password of the user the method connects to the
     *             database and confirms if the user is a registered user
     *             in the site and then returns a value.
     * @return true if the user login details (username and password) is
     *         found in the database and false is it is not found.
     * @throws Exception of type Exception.
     */
    boolean createConnection(String name, String pass) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/flexi";
        String password = "root";
        String username = "postgres";
        String query = "Select * from flexi_users";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        String loginName = "";
        String loginPassword = "";
        while (rs.next()){
            loginName = rs.getString("user_name");
            loginPassword = rs.getString("user_password");
            if(loginName.equalsIgnoreCase(name) && loginPassword.equals(pass))
                return true;
        }
        return false;
    }
}
