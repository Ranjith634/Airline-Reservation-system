package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.exception.FlightManagementException;
import com.demo.exception.FlightNotFoundException;
import com.demo.exception.TicketManagementException;
import com.demo.vo.FlightVO;

public class FlightDAO {
	public boolean addFlightDetails(FlightVO vo)throws FlightManagementException
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
	String query="INSERT INTO Flight(Flight_id,Flight_name ,Source_id, Destination_id , Arrival_Date ,Departure_date))VALUES (?,?,?,?,?,?)";
	stmt=connection.prepareStatement(query);
	stmt.setInt(1,vo.getFlight_id());
	stmt.setString(2,vo.getFlight_name());
	stmt.setInt(3, vo.getSource_id());
	stmt.setInt(4,vo.getDestination_id());
	stmt.setTime(5,vo.getArrival_time());
	stmt.setTime(6,vo.getDeparture_time());
	int i=stmt.executeUpdate(query);
	flag=true;
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when adding Flight details"+e.getMessage());

	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when adding Flight details"+e.getMessage());

	}
	}
	return false;
	}

	public FlightVO fetchFlightById(int Flight_id) throws FlightManagementException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	FlightVO vo=new FlightVO();

	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Flight where Flight_id=?";
	stmt= connection.prepareStatement(query);
	while(rs.next()){
	int Flight_id1=rs.getInt("Flight_id");
	String Flight_name=rs.getString("Flight_name");
	int Source_id=rs.getInt("Source_id");
	int Destination_id=rs.getInt("Destination_id");
	Time Arrival_time=rs.getTime("Arrival_time");
	Time Departure_time=rs.getTime("Departure_time");
	System.out.println(Flight_id1 + " "+ Flight_name +" "+ Source_id +" "+ Destination_id +" "+Arrival_time +" "+ Departure_time +" ");

	}
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when adding Flight details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when adding Flight details"+e.getMessage());
	}
	}
	return vo;
	}
	public List<FlightVO> fetchFlightByFlight_name(String Flight_name)throws FlightNotFoundException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	FlightVO vo=new FlightVO();
	List<FlightVO> list = new ArrayList<FlightVO>();
	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Flight where Ticket_fare=?";
	stmt= connection.prepareStatement(query);
	rs=stmt.executeQuery(query);
	while(rs.next()){
		int Flight_id=rs.getInt("Flight_id");
		String Flight_name1=rs.getString("Flight_name");
		int Source_id=rs.getInt("Source_id");
		int Destination_id=rs.getInt("Destination_id");
		Time Arrival_time=rs.getTime("Arrival_time");
		Time Departure_time=rs.getTime("Departure_time");
		System.out.println(Flight_id + " "+Flight_name +" "+ Source_id +" "+ Destination_id +" "+ Arrival_time +" "+ Departure_time+" ");

	}
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	e.getMessage();
	}
	}
	return list;
	}

	public boolean updateFlight(FlightVO vo)throws FlightManagementException
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
	String query="UPDATE Flight set Flight_name=?,Source_id=?,Destination_id=?,Arrival_time=?,Departure_time=? where Flight_id=?";
	stmt= connection.prepareStatement(query);
	stmt.setString(1, vo.getFlight_name());
	stmt.setInt(2, vo.getSource_id());
	stmt.setInt(3,vo.getDestination_id());
	stmt.setTime(4,vo.getArrival_time());
	stmt.setTime(5, vo.getDeparture_time());
	stmt.setInt(6, vo.getFlight_id());
	int i=stmt.executeUpdate(query);
	System.out.println("Updated the Ticket Details Successfully...");
	flag=true;
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when updating Flight details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new FlightManagementException("Error when updating Flight details"+e.getMessage());
	}
	}
	return false;
	}
	}



