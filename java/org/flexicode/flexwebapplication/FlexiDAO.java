package org.flexicode.flexwebapplication;

import java.sql.*;

public class FlexiDAO {
     protected FlexiUsers user;

    /**
     * A simple constructor for the FlexiDao class
     */
    public FlexiDAO(){
     }

    /**
     * This method is used to add a new user to the database
     * @param user is of type FlexiUsers a class that is used to keep account of all the different users of the app
     * @throws Exception due to the statement of creating the prepared statement and statement itself.
     */
     public void createNewUser(FlexiUsers user) throws Exception {
         String insert = "insert into users_details values(?, ?, ?, ?, ? ,?,?)";
         String select = "select * from flexi_users";
         Connection con = createConnection();
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
         insert = "insert into flexi_users values(''?,?,?,?)";
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
        return con;
    }

   void updateUser(FlexiUsers user) throws Exception{
        //TODO -- Planning to write the logic behind updating the users information upon the user request,
       

   }
   void getUser() throws Exception{
        //TODO -- Planning to write the logic behind getting the users information upon the user request,
   }
   void deleteUser() throws Exception{
        //TODO -- Planning to write the logic behind deleting a users information when the user request to deletes his account,
   }
   void selectUser() throws Exception{
        //TODO -- Planning to write the logic behind selecting a users information from the database whenever the user tries to access the account,
   }
}
