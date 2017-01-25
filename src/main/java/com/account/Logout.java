/**
 * 
 */
package com.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Logout extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("=====init method is called====");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      HttpSession session = request.getSession(false);
      if (session != null){
    	  session.invalidate();
    	  response.setStatus(response.SC_MOVED_TEMPORARILY);
 		 response.setHeader("Location", "login.jsp");
      }
    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    @Override
    public void destroy() {
        System.out.println("=====destroy method is called====");
    }
}
