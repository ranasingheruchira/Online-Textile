package com.jayasadha.inquiry_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class ContactDbUtil {


	//private static boolean isInsert;
    private static Connection con = null;
    //private static Statement statem = null;
    //private static ResultSet rss = null;
    
    
    //view data separate

 public static List<Contact> getContact(String id) throws SQLException{
        
        ArrayList <Contact> contactlist = new ArrayList<>();
       
        
        try {    
        	
        	  con = DbConnection.getDBConnection();
			  Statement state = con.createStatement();;
              String sql = "select * from inquirynew where CusId= '"+id+"'";
              ResultSet rrs = state.executeQuery(sql);
             
             while(rrs.next()) {
            	int Iqid = rrs.getInt(1);
                String Firstname = rrs.getString(2);
                String Lastname =  rrs.getString(3);
                String ContactNum = rrs.getString(4);
                String Types = rrs.getString(5);
                String  Messages = rrs.getString(6);
                String  Cus_date = rrs.getString (7);
                String Reply_msg = rrs.getString(8);
                String  Reply_date = rrs.getString(9);
                String Reply_status = rrs.getString(10);
                
                	                
                Contact c = new   Contact(Iqid, Firstname, Lastname, ContactNum, Types, Messages, Cus_date, Reply_msg, Reply_date, Reply_status);            
                contactlist.add(c);
            }
        
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        return  contactlist;
    } 
    
    
	    
	    
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	//insert inquiry
	public static boolean insertinquiry(String fname , String lname, String mobile, String type ,String message, String id) {
		boolean isInsert = false;		
		
		
		try {
			
			 con = DbConnection.getDBConnection();
			 Statement st = con.createStatement();
			
			
			String db = "insert into inquirynew(Iqid,Fname,Lname,ContactNo,Type,Message,CusId)values(0,'"+fname+"','"+lname+"','"+mobile+"','"+type+"','"+message+"','"+id+"')";
		
            int rs =  st.executeUpdate(db);
		    
		    if(rs > 0) {
		    	isInsert = true;
		    }
		    else {
		    	isInsert = false;
		    }
		
				
		
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		return isInsert;
		
	}
	
	
	
	//update inquiry
	public static boolean updateinquiry(String inq_id, String inq_r , String inq_d2, String inq_s) {
		boolean isSuccess = false;	
		
		//String startDateStr = request.getParameter("date"); 
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		//Date startDate = sdf.parse(inq_d2);

		try {
			
			 java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			 con = DbConnection.getDBConnection();
			 Statement st = con.createStatement();
		 
			 String sql = "update inquirynew set Iqid='"+inq_id+"', ReplyMessage='"+inq_r+"', ReplyDate='"+sqlDate+"', Status='"+inq_s+"'" + "where Iqid='"+inq_id+"' ";
			  
		
		 	 int rs =  st.executeUpdate(sql);
			  		    
			  if(rs > 0) {
				  isSuccess = true;
			  }
			 else {
				 isSuccess = false;
			  }	              	
		    } catch (Exception ex) {
			  
			         ex.printStackTrace();
		    }
			      		
	     return isSuccess;
			      		
	}
			      	
			      	
	
	
	
	
	
	//update inquiry list
	
	 public static List<Contact> getContactList() {
	        
	        ArrayList <Contact> inquirylist = new ArrayList<>();
	       
	        
	        try {
	        	
	        	  con = DbConnection.getDBConnection();
				  Statement s = con.createStatement();;
	              String u_sql = "select * from inquirynew";
	              ResultSet us = s.executeQuery(u_sql);
	            
	             while(us.next()) {
	            	int Iq_id = us.getInt(1);
	                String First_name = us.getString(2);
	                String Last_name =  us.getString(3);
	                String Contact_num = us.getString(4);
	                String I_type = us.getString(5);
	                String  I_messages = us.getString(6);
	                String Cu_date = us.getString(7);
	                String Rep_msg = us.getString(8);
	                String  Rep_date = us.getString (9);
	                String Rep_status = us.getString(10);
	                
	                	                
	                Contact all = new  Contact(Iq_id, First_name, Last_name, Contact_num, I_type, I_messages, Cu_date, Rep_msg, Rep_date, Rep_status);            
	                inquirylist.add(all);
	                
	            }
	        
	        }catch(Exception e){
	            
	            e.printStackTrace();
	        }
	        
	        return   inquirylist;
	    } 
	
	
	
	//delete inquiry
	 public static boolean deleteinquiry(String con_id) {
		 
		 int conId = Integer.parseInt(con_id);
		 boolean isSuccess = false;		

			try {
				
				 con = DbConnection.getDBConnection();
				 Statement sm = con.createStatement();	
				 
				 String d_db = "delete from inquirynew where Iqid='"+conId+"'";
				
				 int r =  sm.executeUpdate(d_db);
				 
				  if(r > 0) {
					  isSuccess = true;
				  }
				 else {
					 isSuccess = false;
				  }	    
			      	
			    } catch (Exception ex) {
				  
				         ex.printStackTrace();
			    }
				      		
		     return isSuccess;
				      		
		}
	 
	 
	 //search inquiry
	 
	 public static List<Contact> getInquiry(String search_iq) throws SQLException{
	        
		    //int search_inq = Integer.parseInt(search_iq);
	        ArrayList <Contact> inquirylist = new ArrayList<>();
	       
	        
	        try {
	        	
	        	  con = DbConnection.getDBConnection();
				  Statement state = con.createStatement();;
	              String sl = "select * from inquirynew where Type= '"+search_iq+"'";
	              ResultSet se = state.executeQuery(sl);
	             
	             while(se.next()) {
	            	int Iqid_s = se.getInt(1);
	                String Firstname_s = se.getString(2);
	                String Lastname_s =  se.getString(3);
	                String ContactNum_s = se.getString(4);
	                String Types_s = se.getString(5);
	                String  Messagess = se.getString(6);
	                String  Cu_date = se.getString (7);
	                String Repl_msg = se.getString(8);
	                String  Repl_date = se.getString(9);
	                String Repl_status = se.getString(10);
	                
	                	                
	                Contact i_search = new   Contact(Iqid_s, Firstname_s, Lastname_s, ContactNum_s, Types_s, Messagess, Cu_date, Repl_msg, Repl_date, Repl_status);            
	                inquirylist.add(i_search);
	            }
	        
	        }catch(Exception e){
	            
	            e.printStackTrace();
	        }
	        
	        return  inquirylist;
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		 
		 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
