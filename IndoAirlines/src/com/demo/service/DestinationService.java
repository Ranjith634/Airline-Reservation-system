package com.demo.service;

import java.util.List;

import com.demo.bo.DestinationBO;
import com.demo.exception.DestinationManagementException;
import com.demo.exception.DestinationNotFoundException;
import com.demo.response.DestinationResponseObject;
import com.demo.vo.DestinationVO;

public class DestinationService {
	DestinationBO bo = new DestinationBO();
	DestinationResponseObject obj = new DestinationResponseObject();
	public DestinationResponseObject addDestination(DestinationVO vo)throws DestinationManagementException
	{
		boolean flag;
		try 
		{
			
			flag = bo.addDestination(vo);
			if (flag)
				obj.setSuccessMessage("Destination Added successfully");

			else
				obj.setFailureMessage("Error When Adding Destination Details, Reach out Administrator");
		}
		catch (DestinationManagementException e){
			obj.setFailureMessage("Error When Adding Destination Details, Reach out Administrator");
		}
		return obj;
	}
	public DestinationResponseObject fetchDestinationById(Integer Destination_id) throws DestinationNotFoundException{

		try {
			DestinationVO vo;
			vo = bo.fetchDestinationById(Destination_id);
			obj.setDestinationVo(vo);
		} catch (DestinationNotFoundException e) {
			obj.setFailureMessage("Fetch Ticket is not in the List" + e.getMessage());
		}

		return obj;
	}
	public DestinationResponseObject fetchDestinationByName(String Destination_name) throws DestinationNotFoundException {
		try {
			List<DestinationVO> list;
			list= bo.fetchDestinationByName(Destination_name)
;			obj.setDestinationVOList(list);
		} catch (DestinationNotFoundException e) {
			obj.setFailureMessage("Fetch Flight is not in the List" + e.getMessage());
		}

		return obj;
	}

	

	public DestinationResponseObject updateDestination(DestinationVO vo) throws DestinationManagementException
	{
		boolean flag;
		try 
		{
			flag = bo.updateDestination(vo);
			if (flag)
				obj.setSuccessMessage("Destination updated successfully");
			else
				obj.setFailureMessage("Error When updated Destination Details, Reach out Administrator");
		}
		catch (DestinationManagementException e){
			obj.getFailureMessage();
		}
		return obj;
}
}
