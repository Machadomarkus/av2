package com.mvc.controller;
 import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.LoginBean;
 import com.mvc.dao.LoginDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
 
public class LoginServlet extends HttpServlet {

    private Object name;
 
public LoginServlet() {
 }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    try {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        LoginBean loginBean = new LoginBean(); 
        loginBean.setEmail(email); 
        loginBean.setPass(pass);
         
        LoginDao loginDao = new LoginDao(); 
        
        String userValidate = loginDao.authenticateUser(loginBean); 
        
        if(userValidate.equals("SUCCESS")) 
        {
             HttpSession session=request.getSession();  
              
            request.setAttribute("email", email); 
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("errMessage", userValidate); 
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
            
        }  } catch (SQLException ex) {
        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
 
}