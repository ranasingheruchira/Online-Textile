package com.jayasadha.employee_higher_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBUtil {
	
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	private static ResultSet rs2 = null;

	public static List<User> validate(String eusername, String epassword){
		
		ArrayList<User> us = new ArrayList<>();
		
		//validate
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement(); 
			
			String sql = "select * from user where username='"+eusername+"' and password='"+epassword+"'";
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String contactno=rs.getString(5);
				String adline1=rs.getString(6);
				String adline2=rs.getString(7);
				String city=rs.getString(8);
				String username=rs.getString(9);
				String password=rs.getString(10);
				
				User u = new User(id,fname,lname,contactno,email,adline1,adline2,city,username,password);
				
				us.add(u);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return us;
		
	}
	
	public static boolean validateNew(String eusername, String epassword){
		
	boolean isSuccess = false;
	
		//validate
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement(); 
			
			String sql = "select * from user where username='"+eusername+"' and password='"+epassword+"'";
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	
	
	
	
	public static boolean validSearchEmployee(String eFname){
		
		boolean isSuccess=false;
		
		try {
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "SELECT EXISTS(SELECT * FROM user WHERE fName='"+eFname+"')";
			ResultSet r = stat.executeQuery(sql);
			
			if(r.next()){
				
				int value = r.getInt(1);
				
				if(value>0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<User> getOnlyUser(String uname){
		
		ArrayList<User> user = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from user where username='"+uname+"'";
			
			rs1 =stat.executeQuery(sql);
			
			while(rs1.next()) {
				
				int uid = rs1.getInt(1);
				String fname = rs1.getString(2);
				String lname = rs1.getString(3);
				String contactno=rs.getString(4);
				String email=rs.getString(5);
				String adline1 = rs1.getString(6);
				String adline2= rs1.getString(7);
				String city = rs1.getString(8);
				String username = rs1.getString(9);
				String password = rs1.getString(10);
				
				User u = new User(uid,fname,lname,contactno,email,adline1,adline2,city,username,password);
				
				user.add(u);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	
	public static boolean insertEmployee (String efname, String elname, String econtactno, String eemail, String eadline1, String eadline2, String ecity, String eusername, String epassword, String enic, String edob, String epositionid) {
		
		boolean isSuccess = false;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql1 = "INSERT INTO user VALUES (0, '"+efname+"', '"+elname+"', '"+econtactno+"', '"+eemail+"', '"+eadline1+"', '"+eadline2+"', '"+ecity+"', '"+eusername+"', '"+epassword+"')";
			String sql2 = "INSERT INTO employee VALUES (0, '"+enic+"', '"+edob+"', '"+epositionid+"')";
			
			int rs1 = stat.executeUpdate(sql1);
			int rs2 = stat.executeUpdate(sql2);
			
			if(rs1>0 && rs2>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean insertNewEUser (String efname, String elname, String econtactno, String eemail, String eadline1, String eadline2, String ecity, String eusername, String epassword) {
		
		boolean isSuccess = false;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "INSERT INTO user VALUES (0, '"+efname+"', '"+elname+"', '"+econtactno+"', '"+eemail+"', '"+eadline1+"', '"+eadline2+"', '"+ecity+"', '"+eusername+"', '"+epassword+"', 'Employee', now())";
			
			int rs = stat.executeUpdate(sql);
			
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public static int getMaxUserID() {
		
		
		int value = 0;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql1 = "SELECT max(userId) FROM user";
			ResultSet r = stat.executeQuery(sql1);
			
			if(r.next()){
				
				value = r.getInt(1);	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return value;
	}
	
	
	public static boolean insertNewEmployee (String enic, String edob, String epositionid) {
		
		boolean isSuccess = false;
		int eid=0;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			eid = getMaxUserID();
			
			String sql2 = "INSERT INTO employee VALUES ( '"+eid+"' , '"+enic+"', '"+edob+"', '"+epositionid+"')";
		
			int rs = stat.executeUpdate(sql2);
			
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	

	public static List<Employee> getEmployeeDetails(String eId){
	
		int convertedeid = Integer.parseInt(eId);
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from Employee where EmpID='"+convertedeid+"'";
			
			rs2 =stat.executeQuery(sql);
			
			while(rs2.next()) {
				
				int uid = rs2.getInt(1);
				String nic = rs2.getString(2);
				String dob = rs2.getString(3);
				String positionid = rs2.getString(4);
				
				Employee e = new Employee(uid,nic,dob,positionid);
			
				emp.add(e);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public static List<User> getUserDetails(String id){
		
		int convertedid = Integer.parseInt(id);
		
		ArrayList<User> user = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from user where userId='"+convertedid+"'";
			
			rs1 =stat.executeQuery(sql);
			
			while(rs1.next()) {
				
				int uid = rs1.getInt(1);
				String fname = rs1.getString(2);
				String lname = rs1.getString(3);
				String contactno = rs1.getString(4);
				String email = rs1.getString(5);
				String adline1 = rs1.getString(6);
				String adline2= rs1.getString(7);
				String city = rs1.getString(8);
				String username = rs1.getString(9);
				String password = rs1.getString(10);
				
				User u = new User(uid,fname,lname,contactno,email,adline1,adline2,city,username,password);
				
				user.add(u);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static List<Employee> getEmployeeDetailsByName(String eName){
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from employee e JOIN user u ON u.userId = e.EmpID where EmpID in (select userId from user where fName='"+eName+"')";
			
			rs2 =stat.executeQuery(sql);
			
			while(rs2.next()) {
				
				int uid = rs2.getInt(1);
				String nic = rs2.getString(2);
				String dob = rs2.getString(3);
				String positionid = rs2.getString(4);
				
				Employee e = new Employee(uid,nic,dob,positionid);
			
				emp.add(e);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public static List<User> getUserDetailsByName(String eName){
		
		ArrayList<User> user = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from user where fName='"+eName+"'";
			
			rs1 =stat.executeQuery(sql);
			
			while(rs1.next()) {
				
				int uid = rs1.getInt(1);
				String fname = rs1.getString(2);
				String lname = rs1.getString(3);
				String contactno = rs1.getString(4);
				String email = rs1.getString(5);
				String adline1 = rs1.getString(6);
				String adline2= rs1.getString(7);
				String city = rs1.getString(8);
				String username = rs1.getString(9);
				String password = rs1.getString(10);
				
				User u = new User(uid,fname,lname,contactno,email,adline1,adline2,city,username,password);
				
				user.add(u);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static List<Common> getCommonDetailsByName(String eName){
		
		ArrayList<Common> com = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select userId,fName,lName,phone,email,addrLine1,addrLine2,addrLine3,username,password,EmpID,NIC,DOB,PositionID from jayasadha.user u JOIN jayasadha.employee e ON u.userId = e.EmpID where EmpID in (select userId from jayasadha.user where fName='"+eName+"')";
			rs1 =stat.executeQuery(sql);
			
			while(rs1.next()) {
				
				int uid = rs1.getInt(1);
				String fname = rs1.getString(2);
				String lname = rs1.getString(3);
				String contactno = rs1.getString(4);
				String email = rs1.getString(5);
				String adline1 = rs1.getString(6);
				String adline2= rs1.getString(7);
				String city = rs1.getString(8);
				String username = rs1.getString(9);
				String password = rs1.getString(10);
				int eid = rs1.getInt(11);
				String nic = rs1.getString(12);
				String dob = rs1.getString(13);
				String positionid = rs1.getString(14);
				
				Common c = new Common(uid,fname,lname,contactno,email,adline1,adline2,city,username,password,eid,nic,dob,positionid);
				
				com.add(c);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return com;
	}
	
	public static int getTotalEmployeeCount() {
		
		
		int eCount = 0;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql1 = "(select count(u.userId) from jayasadha.employee e JOIN jayasadha.user u ON u.userId = e.EmpID where EmpID in (select userId from jayasanda.user where fName='Amali'))";
			ResultSet r = stat.executeQuery(sql1);
			
			if(r.next()){
				
				eCount = r.getInt(1);	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return eCount;
	}
	
	
	public static boolean updateUser(String id, String fname, String lname,  String contactno, String email, String adline1, String adline2, String city, String username, String password) {
		
		boolean isSuccess = false;
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "update user set fName='"+fname+"', lName='"+lname+"', phone='"+contactno+"', email='"+email+"', addrLine1='"+adline1+"', addrLine2='"+adline2+"', addrLine3='"+city+"', username='"+username+"', password='"+password+"' where userId='"+id+"'";
			int rs = stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static boolean updateEmployee(String id, String nic, String dob,String positionid) {
		
		boolean isSuccess = false;
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "update employee set NIC='"+nic+"', DOB='"+dob+"', PositionID='"+positionid+"' where EmpID='"+id+"'";
			int rs = stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static boolean insertRequest(String empID, String requiredDate, String advanceAmount, String reason) {
		
		boolean isSuccess = false;
		
		//Insert
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "INSERT INTO advanced_requests VALUES (0, '"+empID+"', default, '"+requiredDate+"', '"+advanceAmount+"', '"+reason+"', default)";
			
			int rs = stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<AdvanceRequest> viewPersonalRequests(String eID){
		
		int convertedeid = Integer.parseInt(eID);
		
		ArrayList<AdvanceRequest> adRq = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from advanced_requests where EmployeeID = '"+convertedeid+"'";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				 int eRequestID = rs.getInt(1);
				 int eEmployeeID = rs.getInt(2);
				 String eRequestedDate = rs.getString(3);
				 String eRequiredDate = rs.getString(4);
				 String eAdvanceAmount = rs.getString(5);
				 String eReason = rs.getString(6);
				 String eRqStatus = rs.getString(7);
				 
				 AdvanceRequest ad = new AdvanceRequest(eRequestID, eEmployeeID, eRequestedDate, eRequiredDate, eAdvanceAmount, eReason, eRqStatus);
				 adRq.add(ad);	 
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return adRq;
		
	}

	public static boolean deleteRequest(String ID) {
		
		int convID = Integer.parseInt(ID);

		boolean isSuccess=false;
		
		try {
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "delete from advanced_requests where RequestID='"+convID+"'";
			int r = stat.executeUpdate(sql);
			
			if(r>0){
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean deleteRequestValidity(String ID) {
		
			
		int convID = Integer.parseInt(ID);

		boolean isSuccess=false;
		
		try {
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "SELECT TIMESTAMPDIFF(DAY,RequestedDate, curdate()) AS NoDays FROM advanced_requests where RequestID='"+convID+"'";
			ResultSet r = stat.executeQuery(sql);
			
			if(r.next()){
				
				int value = r.getInt(1);
				
				if(value<=2) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static List<AdvanceRequest> checkAvailableRequests(){
		
		ArrayList<AdvanceRequest> adRq = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "select * from advanced_requests where RequestStatus = 'pending' and DATEDIFF(curdate(),RequestedDate)>3;";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				 int eRequestID = rs.getInt(1);
				 int eEmployeeID = rs.getInt(2);
				 String eRequestedDate = rs.getString(3);
				 String eRequiredDate = rs.getString(4);
				 String eAdvanceAmount = rs.getString(5);
				 String eReason = rs.getString(6);
				 String eRqStatus = rs.getString(7);
				 
				 AdvanceRequest ad = new AdvanceRequest(eRequestID, eEmployeeID, eRequestedDate, eRequiredDate, eAdvanceAmount, eReason, eRqStatus);
				 adRq.add(ad);	 
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return adRq;
		
	}
	
	public static boolean AcceptRequest(String ID, String rqStatus) {
		
		int convID = Integer.parseInt(ID);

		boolean isSuccess=false;
		
		try {
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "update advanced_requests set RequestStatus='Accepted' where RequestID='"+convID+"'";
			int r = stat.executeUpdate(sql);
			
			if(r>0){
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean RejectRequest(String ID, String rqStatus) {
		
		int convID = Integer.parseInt(ID);

		boolean isSuccess=false;
		
		try {
			con = ConnectionDB.getConnection();
			stat = con.createStatement();
			
			String sql = "update advanced_requests set RequestStatus='Rejected' where RequestID='"+convID+"'";
			int r = stat.executeUpdate(sql);
			
			if(r>0){
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}


}
