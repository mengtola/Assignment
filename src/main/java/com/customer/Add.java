/**
 * 
 */
package com.customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import jdk.nashorn.internal.ir.ObjectNode;


@SuppressWarnings("serial")
public class Add extends HttpServlet {
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;
    
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
    	
    	
    	 try {
    		 
	    	String first_name = request.getParameter("first_name");
	    	String last_name = request.getParameter("last_name");
	    	String gender = request.getParameter("gender");
	    	String email = request.getParameter("email");
	    	String dob = request.getParameter("dob");
	    	String address = request.getParameter("address");
	    	String phone = request.getParameter("phone");
	    	
    		 
    	       // load jdbc driver
             Class.forName(props.getProperty("driverClassName"));
             // load connection driver
             connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
         
             // execute select statement
             preparedStatement = connection.prepareStatement("insert into td_customer (cus_first_name,cus_last_name,cus_gender,cus_email_address,cus_dob,cus_address,cus_phone,cus_created,cus_updated) values(?,?,?,?,?,?,?,now(),now())");
             preparedStatement.setString(1, first_name);
             preparedStatement.setString(2, last_name);
             preparedStatement.setString(3, gender);
             preparedStatement.setString(4, email);
             preparedStatement.setString(5, dob);
             preparedStatement.setString(6, address);
             preparedStatement.setString(7, phone);
     
             //return data to resultSet
             int total = preparedStatement.executeUpdate();
            
             if (total > 0){
            	 response.setStatus(response.SC_MOVED_TEMPORARILY);
        		 response.setHeader("Location", "index.jsp");
             } else {
            	 
            	 response.setStatus(response.SC_MOVED_TEMPORARILY);
        		 response.setHeader("Location", "add.jsp");
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
