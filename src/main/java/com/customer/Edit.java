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

import javax.servlet.RequestDispatcher;
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
public class Edit extends HttpServlet {
    
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
    	try{
	    	 int id =Integer.parseInt(request.getParameter("id"));
	    	 // load connection driver
	         connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
	     
	         // execute select statement
	         preparedStatement = connection.prepareStatement("select * from td_customer where cus_id=?");
	         preparedStatement.setInt(1,id);
	         
	         //return data to resultSet
	         resultSet = preparedStatement.executeQuery();
	         // get result
	         if(resultSet.next()){
	        	request.setAttribute("first_name", resultSet.getString(2));
	        	request.setAttribute("last_name", resultSet.getString(3));
	        	request.setAttribute("gender", resultSet.getString(4));
	        	request.setAttribute("email", resultSet.getString(5));
	        	request.setAttribute("dob", resultSet.getString(6));
	        	request.setAttribute("address", resultSet.getString(7));
	        	request.setAttribute("phone", resultSet.getString(8));
	        	
	        	RequestDispatcher dispatcher =request.getRequestDispatcher("edit.jsp");
	        	dispatcher.forward(request,response);
	        	
	         } else {
	        	 
	        	 RequestDispatcher dispatcher =request.getRequestDispatcher("edit.jsp");
		        dispatcher.forward(request,response);
	         }
	         
	         
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	     finally {
	    	close();
	     }
	    	 
	    }

    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	 try {
    		int id =Integer.parseInt(request.getParameter("id"));
    		
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
             preparedStatement = connection.prepareStatement("update td_customer set cus_first_name =?,cus_last_name=?,cus_gender=?,cus_email_address=?,cus_dob=?,cus_address=?,cus_phone=?,cus_updated=now() where cus_id=?");
             preparedStatement.setString(1, first_name);
             preparedStatement.setString(2, last_name);
             preparedStatement.setString(3, gender);
             preparedStatement.setString(4, email);
             preparedStatement.setString(5, dob);
             preparedStatement.setString(6, address);
             preparedStatement.setString(7, phone);
             preparedStatement.setInt(8, id);
     
             //return data to resultSet
             int total = preparedStatement.executeUpdate();
            
             if (total > 0){
            	 response.setStatus(response.SC_MOVED_TEMPORARILY);
        		 response.setHeader("Location", "index.jsp");
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
