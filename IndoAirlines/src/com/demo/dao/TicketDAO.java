package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.exception.TicketManagementException;
import com.demo.exception.TicketNotFoundException;
import com.demo.vo.TicketVO;

public class TicketDAO {
	public boolean addTicketDetails(TicketVO vo)throws TicketManagementException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement ps=null;
	boolean flag;
    try
	{
    connection = DriverManager.getConnection(url,userName, password);
	String query="INSERT INTO ticket(Ticket_id,Reg_id,Source_id, Destination_id,Departure_date,Return_date,Ticket_fare)VALUES (?,?,?,?,?,?,?)";
	ps=connection.prepareStatement(query);
	ps.setInt(1,vo.getTicket_id());
	ps.setInt(2,vo.getReg_id());
	ps.setInt(3,vo.getSource_id());
	ps.setInt(4,vo.getDestination_id());
	ps.setDate(5,vo.getDeparture_date());
	ps.setDate(6,vo.getReturn_date());
	ps.setLong(7,vo.getTicket_fare());
	ps.executeUpdate();
	flag=true;
	}
	catch(SQLException e)
	{
		throw new TicketManagementException("Error when adding ticket details"+e.getMessage());

	}
	finally{
	try{
	ps.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new TicketManagementException("Error when adding ticket details"+e.getMessage());

	}
	}
	return flag;
	}

	public TicketVO fetchTicketById(int Ticket_id)throws TicketNotFoundException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	TicketVO vo=new TicketVO();
	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Ticket where Ticket_id=?";
	stmt= connection.prepareStatement(query);
	stmt.setInt(1, Ticket_id);
	rs=stmt.executeQuery();
	while(rs.next()){
	vo.setTicket_id(rs.getInt("Ticket_id"));
	vo.setReg_id(rs.getInt("Reg_id"));
	vo.setSource_id(rs.getInt("Source_id"));
	vo.setDestination_id(rs.getInt("Destination_id"));
	vo.setDeparture_date(rs.getDate("Departure_date"));
	vo.setReturn_date(rs.getDate("Return_date"));
	vo.setTicket_fare(rs.getLong("Ticket_fare"));
	}
	}
	catch(SQLException e)
	{
		throw new TicketNotFoundException("Error when fetching ticket details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new TicketNotFoundException("Error when fetching ticket details"+e.getMessage());
	}
	}
	return vo;
	}
	public List <TicketVO> fetchTicketByTicket_fare(Long Ticket_fare)throws TicketNotFoundException
	{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	TicketVO vo=new TicketVO();
	List<TicketVO> list = new ArrayList<TicketVO>();
	try
	{
	connection = DriverManager.getConnection(url, userName, password);
	String query="select * from Ticket where Ticket_fare=?";
	stmt= connection.prepareStatement(query);
	stmt.setLong(1, Ticket_fare);
	rs=stmt.executeQuery();
	while(rs.next()){
	vo.setTicket_id(rs.getInt("Ticket_id"));
	vo.setReg_id(rs.getInt("Reg_id"));
	vo.setSource_id(rs.getInt("Source_id"));
	vo.setDestination_id(rs.getInt("Destination_id"));
	vo.setDeparture_date(rs.getDate("Departure_date"));
	vo.setReturn_date(rs.getDate("Return_date"));
	vo.setTicket_fare(rs.getLong("Ticket_fare"));
	list.add(vo);
	}
	}
	catch(SQLException e)
	{
		throw new TicketNotFoundException("Error when fetching ticket details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new TicketNotFoundException("Error when fetching ticket details"+e.getMessage());

	}
	}
	return list;
	}

	public boolean updateTicketDetails(TicketVO vo)throws TicketManagementException
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
	String query="UPDATE Ticket set Reg_id=?,Source_id=?,Destination_id=?,Departure_Date=?,Return_Date=?,Ticket_fare=? where Ticket_id=?";
	stmt= connection.prepareStatement(query);
	stmt.setInt(1, vo.getReg_id());
	stmt.setInt(2, vo.getSource_id());
	stmt.setInt(3,vo.getDestination_id());
	stmt.setDate(4, vo.getDeparture_date());
	stmt.setDate(5,vo.getReturn_date());
	stmt.setDouble(6, vo.getTicket_fare());
	stmt.setInt(7, vo.getTicket_id());
	stmt.executeUpdate();
	flag=true;
	}
	catch(SQLException e)
	{
		throw new TicketManagementException("Error when updating ticket details"+e.getMessage());
	}
	finally{
	try{
	stmt.close();
	connection.close();
	}
	catch(SQLException e)
	{
		throw new TicketManagementException("Error when updating ticket details"+e.getMessage());
	}
	}
	return flag;
	}
	}

