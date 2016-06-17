package com.mvc.dao;
 
import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import com.mvc.bean.LoginBean;
 import com.mvc.util.DBConnection;
import java.sql.SQLException;
 public class LoginDao {

    private Object name;
 public String authenticateUser(LoginBean loginBean) throws SQLException
 {
 
String email = loginBean.getEmail(); //Keeping user entered values in temporary variables.
String pass = loginBean.getPass();

Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
String userEmailDB = "";
 String passDB = "";

 

 con = DBConnection.createConnection(); //establishing connection
 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
 resultSet = statement.executeQuery("select * from login"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
 
while(resultSet.next()) // Until next row is present otherwise it return false
 {
  userEmailDB = resultSet.getString("email"); //fetch the values present in database
  passDB = resultSet.getString("pass");
  
  
  
 
   if(email.equals(userEmailDB) && pass.equals(passDB))
   {
      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
   }
 }
 
 return "Invalid user credentials"; // Just returning appropriate message otherwise
 }
 }