package org.flexicode.flexwebapplication;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "CreateAccountServlet", value = "/create-account")
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("user_email");
         String firstName = request.getParameter("first_name");
         String middleName = request.getParameter("middle_name");
         String lastName = request.getParameter("last_name");
//         String dob = request.getParameter("dob");
//        Date date = new Date(dob);
        String country = request.getParameter("country");
        String language = request.getParameter("language");
        FlexiUsers user = new FlexiUsers(username,password,email,country,firstName,middleName,lastName,language);
        FlexiDAO dao = new FlexiDAO();
       try  {
            dao.createNewUser(user);
           System.out.println("A new User has been registered and added to the database");
        }
            catch(Exception e){
              String errorMessage = e.toString();
              System.out.println(errorMessage);
//              System.exit(1);
        }
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Account Created</title>\n" +
                "</head>\n" +
                "<body>");
        out.println("<h2> Hello " + username + " your Flexi app account has been created successfully</h2>");
        out.println("<br><br><br><br><br><br>");
        out.println("Click on the link below to access your home page ");
        out.println("<input type=\"submit\" value=\"Homepage\"");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    void createAccount() throws Exception{

    }
}
