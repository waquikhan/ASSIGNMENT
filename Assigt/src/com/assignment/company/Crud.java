package com.assignment.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Crud 
{
	public static void main(String[] args) throws SQLException
	{
		Driver d1= new Driver();
		DriverManager.registerDriver(d1);
		
		String dburl = "jdbc:mysql://localhost:3306/ASSIGNMENT?";
		Connection CON=DriverManager.getConnection(dburl,"root","root");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter 1 for insert data into Student Table");
		System.out.println("Eneter 2 for Update data into Student Table");
		System.out.println("Eneter 3 for Delete data into Student Table");
		System.out.println("Eneter 4 for for get List of all Student");
		System.out.println("Eneter 5 for getting Student information with Student_No");
		
		int num=sc.nextInt();
		
		switch (num)
		{
		case 1:
			
		{
			DBOperation.insert(CON,sc);
			break;
		}
		
		case 2:
		{
			DBOperation.update(CON,sc);
			break;
		}
		
		case 3:
		{
			DBOperation.delete(CON,sc);
			break;
		}
		
		case 4:
		{
			DBOperation.getlist(CON);
			break;
		}
		
		case 5:
		{
			DBOperation.getlistFilter(CON,sc);
			break;
		}
		
		default:
		{
			System.out.println("Eneter the valid Entery");
			break;
		}
		}
		
		
		
	}

}
