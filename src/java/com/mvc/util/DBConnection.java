package com.mvc.util;
 
import java.sql.Connection;
 import java.sql.DriverManager;
 
public class DBConnection {
 
public static Connection createConnection()
 {
 Connection con = null;
 String url = "jdbc:mysql://localhost:3307/av2"; //for SQL and oracle or any other db server this url differs. where ravi is the database name and 3306 is the port where mysql is running
 String username = "root"; //username of database user
 String password = "1234"; //password
 
try
 {
 try
 {
 Class.forName("com.mysql.jdbc.Driver");// differs from DB server to server
 }
 catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 }
 
con = DriverManager.getConnection(url, username, password);
 
}
 catch (Exception e)
 {
 e.printStackTrace();
 }
 
return con;
 }
 }