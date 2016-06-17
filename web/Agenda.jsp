<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3307/av2"
        user="root" password="1234"
    />
     
    <sql:query var="listAgenda"   dataSource="${myDS}">
        SELECT * FROM agenda;
    </sql:query>
     
    <div align="center">
         <hr>
            <caption><h2>List of users</h2></caption>
            <hr>
        <table border="1" cellpadding="5">
           
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Age</th>
            </tr>
            <c:forEach var="agenda" items="${listAgenda.rows}">
                <tr>
                    <td><c:out value="${agenda.id}" /></td>
                    <td><c:out value="${agenda.name}" /></td>
                    <td><c:out value="${agenda.lastname}" /></td>
                    <td><c:out value="${agenda.phone}" /></td>
                    <td><c:out value="${agenda.age}" /></td>
                </tr>
            </c:forEach>
        </table>
            
            <br> <br>
            
               <form action="HomeServlet"> 
            <input type="submit" value="Back"> 
      </form> 
            
            <br>
            
            <br>
            
            <form action="LogoutServlet"> 
    <input type="submit" value="Logout"> 
      </form> 
    </div>
</body>
</html>