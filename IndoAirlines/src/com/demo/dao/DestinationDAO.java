package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.DestinationManagementException;
import com.demo.exception.DestinationNotFoundException;
import com.demo.vo.DestinationVO;

public class DestinationDAO {
	public boolean addDestinationDetails(DestinationVO vo)throws DestinationManagementException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	boolean flag;
	try
	{
	connection = DriverManager.getConnection(url,userName, password);
	String query="INSERT INTO Destination(Destination_id,Destination_name))VALUES (?,?,)";
	stmt=connection.prepareStatement(query);
	stmt.setInt(1,vo.getDestination_id());
	stmt.setString(2,vo.getDestination_name());
	stmt.executeUpdate();
	flag=true;
	}
	catch(SQLException e)
	{
		throw new DestinationManagementException("Error when adding Destination details"+e.getMessage());

	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new DestinationManagementException("Error when adding Destination details"+e.getMessage());

	}
	}
	return flag;
	}

	public DestinationVO fetchDestinationById(int Destination_id)throws DestinationNotFoundException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	DestinationVO vo=new DestinationVO();
	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Destination where Destination_id=?";
	stmt= connection.prepareStatement(query);
	stmt.setInt(1, Destination_id);
	rs=stmt.executeQuery();
	while(rs.next()){
	vo.setDestination_id(rs.getInt("Destination_id"));
	vo.setDestination_name(rs.getString("Destination_name"));
	}
	}
	catch(SQLException e)
	{
	throw new DestinationNotFoundException("Error when Fetching"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new DestinationNotFoundException("Error when Fetching"+e.getMessage());

	}
	}
	return vo;
	}
	public List<DestinationVO> fetchDestinationByName(String Destination_name)throws DestinationNotFoundException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	DestinationVO vo=new DestinationVO();
	List<DestinationVO> list=new ArrayList<DestinationVO>();

	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Destination where Destination_name=?";
	stmt= connection.prepareStatement(query);
	stmt.setString(1, Destination_name);
	rs=stmt.executeQuery(query);
	while(rs.next()){
		vo.setDestination_id(rs.getInt("Destination_id"));
		vo.setDestination_name(rs.getString("Destination_name"));
		list.add(vo);

	}
	}
	catch(SQLException e)
	{
		throw new DestinationNotFoundException("Error when Fetching"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new DestinationNotFoundException("Error when Fetching"+e.getMessage());
	}
	}
	return list;
	
	}

	public boolean updateDestination(DestinationVO vo)throws DestinationManagementException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	boolean flag; 
	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="UPDATE Destination set Destination_name=? where Destination_id=?";
	stmt= connection.prepareStatement(query);
	stmt.setString(1, vo.getDestination_name());
	stmt.setInt(2, vo.getDestination_id());
	stmt.executeUpdate();
	System.out.println("Updated the Destination Details Successfully...");
	flag=true;
	}
	catch(SQLException e)
	{
		throw new DestinationManagementException("Error when updating Destination details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new DestinationManagementException("Error when updating Destination details"+e.getMessage());
	}
	}
	return flag;
	}
	}
