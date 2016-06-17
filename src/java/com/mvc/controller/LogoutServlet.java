package com.mvc.controller;

import java.io.IOException;  
import static java.lang.System.out;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LogoutServlet extends HttpServlet {  
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            
              
             request.getRequestDispatcher("/Logout.jsp").forward(request, response);
              
            HttpSession session=request.getSession();  
            session.invalidate();  
              
           
              
            out.close();  
    }  
}