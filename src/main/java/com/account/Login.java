/**
 * 
 */
package com.account;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Login extends HttpServlet {
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private Properties props = new Properties();
	    
    @Override
    public void init() throws ServletException {
        System.out.println("=====init method is called====");
        try{
        	String propsFile = "db.properties";
        	props.load(Thread.currentThread().getContextClassLoader().getResource(propsFile).openStream());
        	
        }catch(Exception e){}
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String u = request.getParameter("username");
    	String p = request.getParameter("password");
    	
    	
    	 try {
             // load jdbc driver
             Class.forName(props.getProperty("driverClassName"));
             // load connection driver
             connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
         
             // execute select statement
             preparedStatement = connection.prepareStatement("select * from td_user where username=? and password=?");
             preparedStatement.setString(1, u);
             preparedStatement.setString(2, p);
             
             //return data to resultSet
             resultSet = preparedStatement.executeQuery();
             // get result
             if(resultSet.next()){
            	 
            	 HttpSession session = request.getSession(true);
        		 session.setAttribute("UserID", resultSet.getInt(1)); 
        		 response.setStatus(response.SC_MOVED_TEMPORARILY);
        		 response.setHeader("Location", "/");
             } else {
            	 response.setStatus(response.SC_MOVED_TEMPORARILY);
        		 response.setHeader("Location", "login.jsp");
            	 
             }
             
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         finally {
        	close();
         }
    	
    	
    }
    @Override
    public void destroy() {
        System.out.println("=====destroy method is called====");
    }
    
    private void close(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
            	preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
           
        } catch(Exception e){}
    }
}
