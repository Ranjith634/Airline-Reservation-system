package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.FlightDAO;
import com.demo.exception.FlightManagementException;
import com.demo.exception.FlightNotFoundException;
import com.demo.vo.FlightVO;

public class FlightBO {
	FlightDAO dao=new FlightDAO();
	/* add */
	public boolean addFlight(FlightVO vo) throws  FlightManagementException
	{
		boolean flag;
		flag=dao.addFlightDetails(vo);
		return flag;		
	}
			public FlightVO fetchFlightById(int Flight_id) throws FlightNotFoundException, FlightManagementException
	{
		FlightVO vo=new FlightVO();
		vo=dao.fetchFlightById(Flight_id);
		return vo;
	}
	public List<FlightVO> fetchFlightByFlight_name(String Flight_name) throws FlightNotFoundException
	{
		List<FlightVO> list=new ArrayList<FlightVO>();
		list=dao.fetchFlightByFlight_name(Flight_name);
		return list;
	}
	public boolean updateFlight(FlightVO vo) throws FlightManagementException
	{
		boolean flag;
		flag=dao.updateFlight(vo);
		return flag;
		
	}
}
