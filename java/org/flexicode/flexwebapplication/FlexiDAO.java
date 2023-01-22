package org.flexicode.flexwebapplication;

import java.sql.*;

public class FlexiDAO {
     protected FlexiUsers user;

    /**
     * A simple constructor for the FlexiDao class
     */
    public FlexiDAO(){
     }
    Connection con;
    /**
     * This method is used to add a new user to the database
     * @param user is of type FlexiUsers a class that is used to keep account of all the different users of the app
     * @throws Exception due to the statement of creating the prepared statement and statement itself.
     */
     public void createNewUser(FlexiUsers user) throws Exception {
         String insert = "insert into users_details values(?, ?, ?, ?, ? ,?,?)";
         String select = "select * from flexi_users";
         con = createConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(select);
         int i = 1;
         while(rs.next())
             i++;
         PreparedStatement pst = con.prepareStatement(insert);
//         Date dateOfBirth = (Date) user.getDateOfBirth();
         pst.setString(1,user.getUsername());
         pst.setString(2,user.getFirstName());
         pst.setString(3,user.getMiddleName());
         pst.setString(4,user.getLastName());
         pst.setDate(5,null);
         pst.setString(6,user.getCountry());
         pst.setString(7,user.getLanguage());
         insert = "insert into flexi_users values(?,?,?,?)";
         pst.executeUpdate();
         pst = createConnection().prepareStatement(insert);
         pst.setInt(1,i);
         pst.setString(2,user.getUsername());
         pst.setString(3,user.getEmail());
         pst.setString(4,user.getPassword());
         pst.executeUpdate();
         System.out.println("Successfully added user to the database");
     }
     /**
      * This method creates a new connection with the database
      * and is first called any time any method wants to do any processing
      * in the database
      * @return con, which is an object of Connection.
     */
    Connection createConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/flexi";
        String password = "root";
        String username = "postgres";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println("connection created");
        return con;
    }

   void updateUser(FlexiUsers user) throws Exception{
        //TODO -- Planning to write the logic behind updating the users information upon the user request,
        Connection con = createConnection();
        String update = "select * from user_details where username = \'" + user.getUsername() + "'";
        String select = "select * from user_details where username = ";
        PreparedStatement pst = con.prepareStatement(update);

   }

    /**
     * The get method takes in two parameters of type string as seen below
     * @param username is the username of the owner of the specific flexi account
     * @param password is the password of the user that owns the flexi account
     *                 both of these parameters are used to loop through the database
     *                 to find the username and password that best matches the specific user
     *                 that has been registered in the database.
     * @throws Exception the method throws an Exception of the general exception type.
     */
   FlexiUsers getUser(String username,String password) throws Exception{
       ResultSet rs;
        FlexiUsers user = new FlexiUsers();
        con = createConnection();
        String select = "select * from users_details";
        String email = "select * from flexi_users";
        Statement st = con.createStatement();
       System.out.println("querying the first string");
       rs = st.executeQuery(select);
       System.out.println("still querying");
       String name = "";
       while(rs.next()){
           name = rs.getString("user_name");
           if(name.equalsIgnoreCase(username)){
               System.out.println("passed if test");
               String firstName = rs.getString("first_name");
               String middleName = rs.getString("middle_name");
               String lastName = rs.getString("last_name");
               String country = rs.getString("country_of_origin");
               Date date = rs.getDate("date_of_birth");
               String language = rs.getString("language");
               user.setFirstName(firstName);
               user.setLastName(lastName);
               user.setMiddleName(middleName);
               user.setCountry(country);
               user.setUsername(username);
               user.setLanguage(language);
               user.setDateOfBirth(date);
               break;
           }
       }
       rs = st.executeQuery(email);
       while(rs.next()){
           name = rs.getString("user_name");
           String userPass = rs.getString("user_password");
           if(name.equalsIgnoreCase(username) && userPass.equals(password)){
               int userId = (int)(rs.getInt(1));
               String userEmail = rs.getString("user_email");
               user.setUserId(userId);
               user.setEmail(userEmail);
               break;
           }
       }
       System.out.println("queried successfully");
       return user;
        //TODO -- Planning to write the logic behind getting the users information upon the user request,
   }
   void deleteUser() throws Exception{
        //TODO -- Planning to write the logic behind deleting a users information when the user request to deletes his account,
   }
   void selectUser() throws Exception{
        //TODO -- Planning to write the logic behind selecting a users information from the database whenever the user tries to access the account,
   }
}
