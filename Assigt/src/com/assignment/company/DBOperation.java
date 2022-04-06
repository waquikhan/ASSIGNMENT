package com.assignment.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBOperation
{

	//--------------------------------> For insert the Data into Student table    <-----------------------------
	
	
	public static void insert(Connection CON, Scanner sc) throws SQLException
	{
		String query = "insert into STUDENT values(?,?,?,?)";
		PreparedStatement PSTMT = CON.prepareStatement(query);
		
		System.out.println("Please Enter The STUDENT_NO");
		int student_no=sc.nextInt();
		PSTMT.setInt(1, student_no);
		
		System.out.println("Please Enter The STUDENT_NAME");
		String student_name=sc.next();
		PSTMT.setString(2, student_name);
		
		System.out.println("Please Enter The STUDENT_DOB");
		String student_dob=sc.next();
		PSTMT.setString(3, student_dob);
		
		System.out.println("Please Enter The STUDENT_DOJ");
		String student_doj=sc.next();
		PSTMT.setString(4, student_doj);
		
		int ans = PSTMT.executeUpdate();
		
		if(ans>0)
			System.out.println("Student Data Inserted Succeesfully");
		else
			System.out.println("Unable to inserted Student Data");
		
		if(PSTMT!=null)
			PSTMT.close();
		if(CON!=null)
			CON.close();
		
	}
	
	
	//------------------------------->     For Update the student Data From The Student Table    <---------------------------------------------

	public static void update(Connection CON, Scanner sc) throws SQLException 
	{
		
		String query = "update STUDENT set STUDENT_NAME=? where STUDENT_NO=?";
		PreparedStatement PSTMT =CON.prepareStatement(query);
		
		System.out.println("Eneter the student_name to change: ");
		String student_name=sc.next();
		PSTMT.setString(1, student_name);
		
		System.out.println("Eneter the STUDENT_NO os Student");
		int student_no=sc.nextInt();
		PSTMT.setInt(2, student_no);
		
		
		int ans=PSTMT.executeUpdate();
		if(ans!=0)
			System.out.println("Student Data Update Succeesfully");
		else
			System.out.println("Unable to Update Student Data");
		
		if(PSTMT!=null)
			PSTMT.close();
		if(CON!=null)
			CON.close();
		
	}
	
	//---------------------------------->     For Delete the student Data From The Student Table    <-------------------------------------

	public static void delete(Connection CON, Scanner sc) throws SQLException 
	{
		String query = "delete from STUDENT where STUDENT_NO=?";
		PreparedStatement PSTMT = CON.prepareStatement(query);
		System.out.println("Eneter the STUDENT-NO");
		int student_no=sc.nextInt();
		PSTMT.setInt(1, student_no);
		int ans=PSTMT.executeUpdate();
		
		if (ans>0)
			System.out.println("Sutdent Data Delete Succeesfully");
		else
			System.out.println("Unable to Delete Sutdent Data ");
		if (PSTMT!=null)
			PSTMT.close();
		if(CON!=null)
			CON.close();
	}

	
	//----------------------------------->       for getting all Student list From Student table    <---------------------------------------
	
	public static void getlist(Connection CON) throws SQLException 
	{
		Statement STMT=CON.createStatement();
		String query = "select * from STUDENT";
		ResultSet RS =STMT.executeQuery(query);
		
		while (RS.next()) 
		{
			System.out.println("STUDENT_NO--> "+RS.getInt(1)+     "STUDENT_NAME-->"  +RS.getString(2)+"STUDENT_DOB"   
		                          +RS.getString(3)+"STUDENT_DOJ"   +RS.getString(4));
		}
		if (STMT!=null)
		{
			STMT.close();
		}
		if (RS!=null)
		{
			RS.close();
		}	
	}

	
	//--------------------------------------->    For the Filter Student information  from the Student table   <-------------------------
	
	public static void getlistFilter(Connection CON, Scanner sc) throws SQLException
	{
		// TODO Auto-generated method stub
		String query = "select * from STUDENT where STUDENT_NO=?";
		System.out.println("Enter the STUDENT_NO for the details");
		PreparedStatement PSTMT=CON.prepareStatement(query);
		
		int STUDENT_NO=sc.nextInt();
		PSTMT.setInt(1, STUDENT_NO);
		
		ResultSet RS = PSTMT.executeQuery();
		
		while(RS.next())
		{
			System.out.println("STUDENT_NO--> "+RS.getInt(1)+     "STUDENT_NAME-->"  +RS.getString(2)+"STUDENT_DOB"   
                    +RS.getString(3)+"STUDENT_DOJ"   +RS.getString(4));
		}
		if(PSTMT!=null)
			PSTMT.close();
		if(RS!=null)
			RS.close();
		
		
	}
	
}
