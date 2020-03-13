package com.demo.service;

import java.util.List;

import com.demo.bo.FlightBO;
import com.demo.exception.FlightManagementException;
import com.demo.exception.FlightNotFoundException;
import com.demo.exception.TicketManagementException;
import com.demo.response.FlightResponseObject;
import com.demo.response.TicketResponseObject;
import com.demo.vo.FlightVO;
import com.demo.vo.TicketVO;

public class FlightService {
	FlightBO bo = new FlightBO();
	FlightResponseObject obj = new FlightResponseObject();
	public FlightResponseObject addFlight(FlightVO vo) throws FlightManagementException
	{
		boolean flag;
		try 
		{
			
			flag = bo.addFlight(vo);
			if (flag)
				obj.setSuccessMessage("Flight Details Added successfully");
			else
				obj.setFailureMessage("Error When Adding Flight Details, Reach out Administrator");
		}
		catch (FlightManagementException e){
			obj.getFailureMessage();
		}
		return obj;
	}
	public FlightResponseObject fetchFlightById(int Flight_id) throws FlightNotFoundException, FlightManagementException {

		try {
			FlightVO vo;
			vo = bo.fetchFlightById(Flight_id);
			obj.setFlightVO(vo);
		} catch (FlightNotFoundException e) {
			obj.setFailureMessage("Fetch Ticket is not in the List" + e.getMessage());
		}

		return obj;
	}
	public FlightResponseObject fetchFlightByName(String Flight_name) throws FlightNotFoundException {
		try {
			List<FlightVO> list;
			list= bo.fetchFlightByFlight_name(Flight_name);			
			obj.setFlightList(list);
		} 
		catch (FlightNotFoundException e) {
			obj.setFailureMessage("Fetch Flight is not in the List" + e.getMessage());
		}

		return obj;
	}
	
	public FlightResponseObject updateFlight(FlightVO vo) throws FlightManagementException
	{
		boolean flag;
		try 
		{
			flag = bo.updateFlight(vo);
			if (flag)
				obj.setSuccessMessage("Ticket updated successfully");
			else
				obj.setFailureMessage("Error When updated Ticket Details, Reach out Administrator");
		}
		catch (FlightManagementException e){
			obj.getFailureMessage();
		}
		return obj;
}
}

