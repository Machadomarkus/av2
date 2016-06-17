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
 
String email = loginBean.getEmail(); 
String pass = loginBean.getPass();

Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
String userEmailDB = "";
 String passDB = "";

 

 con = DBConnection.createConnection();
 statement = con.createStatement(); 
 resultSet = statement.executeQuery("select * from login"); 
 
while(resultSet.next()) 
 {
  userEmailDB = resultSet.getString("email"); 
  passDB = resultSet.getString("pass");
  
  
  
 
   if(email.equals(userEmailDB) && pass.equals(passDB))
   {
      return "SUCCESS"; 
   }
 }
 
 return "Invalid user credentials"; 
 }
 }