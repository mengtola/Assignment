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
public class Customer extends HttpServlet {
    
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
    		 
	    	int page = (request.getParameter("page") == null)? 1:Integer.parseInt(request.getParameter("page"));
	    	int rows = (request.getParameter("rows") == null)? 20:Integer.parseInt(request.getParameter("rows"));
	    	int offset = (page - 1) * rows;
    		 
    	       // load jdbc driver
             Class.forName(props.getProperty("driverClassName"));
             // load connection driver
             connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
         
             // execute select statement
             preparedStatement = connection.prepareStatement("select cus_id,concat(cus_first_name,' ', cus_last_name) as cus_name,cus_gender,cus_email_address,cus_address,cus_dob,cus_phone,cus_created from td_customer LIMIT ?,?");
             preparedStatement.setInt(1,offset);
             preparedStatement.setInt(2, rows);
             //return data to resultSet
             resultSet = preparedStatement.executeQuery();
            
             
             JSONObject json = new JSONObject();
             JSONArray arr = new JSONArray();
             PrintWriter out = response.getWriter();
            
             // get result
             while(resultSet.next()){
            	 
            	JSONObject row = new JSONObject();
            	row.put("cus_id", resultSet.getString("cus_id"));
            	row.put("cus_name", resultSet.getString("cus_name"));
            	row.put("cus_gender", resultSet.getString("cus_gender"));
            	row.put("cus_email_address", resultSet.getString("cus_email_address"));
            	row.put("cus_dob", resultSet.getDate("cus_dob"));
            	row.put("cus_address", resultSet.getString("cus_address"));
            	row.put("cus_phone", resultSet.getString("cus_phone"));
            	row.put("cus_created", resultSet.getDate("cus_created"));
            	
            	arr.put(row);
             } 
             
            
             
             statement = connection.createStatement();
             resultSet = statement.executeQuery("select count(*) from td_customer");
             resultSet.next();
             
             json.put("rows", arr);
             json.put("total", resultSet.getInt(1));
             out.print(json.toString());
             
             
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
