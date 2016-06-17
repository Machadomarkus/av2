<html>
 <head>
 <title>Home Page</title>
 </head>
 <body>
 
<center><h2>Home Page</h2></center>

<center>
    <hr>
    <h3>  <b> Welcome: </b>  <%=request.getAttribute("email") %> </h3>
    <hr>
 
    <br> <br> 
    <form action="AgendaServlet"> 
            <input type="submit" value="Contacts"> 
      </form> 
 
 <br> <br> 
   <form action="LogoutServlet"> 
    <input type="submit" value="Logout"> 
      </form> 
 
 
 </body>
 </html>
 
  