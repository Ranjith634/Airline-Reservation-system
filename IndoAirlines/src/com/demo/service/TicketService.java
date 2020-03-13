package com.demo.service;

import java.util.List;

import com.demo.bo.TicketBO;
import com.demo.exception.TicketManagementException;
import com.demo.exception.TicketNotFoundException;
import com.demo.response.TicketResponseObject;
import com.demo.vo.TicketVO;

public class TicketService {
	
			TicketBO bo = new TicketBO();
			TicketResponseObject obj = new TicketResponseObject();
			public TicketResponseObject addTicket(TicketVO vo) throws TicketManagementException
			{
				boolean flag;
				try 
				{
					flag = bo.addTicket(vo);
					if (flag)
						obj.setSuccessMessage("Ticket Added successfully");
					else
						obj.setFailureMessage("Error When Adding Passenger Details, Reach out Administrator");
				}
				catch (TicketManagementException e){
					obj.setFailureMessage("Error When Adding Passenger Details, Reach out Administrator");
				}
				return obj;
			}
				public TicketResponseObject fetchTicketById(int Ticket_id) throws TicketNotFoundException {

					try {
						TicketVO vo;
						vo = bo.fetchTicketById(Ticket_id);
						obj.setTicketVo(vo);
					} catch (TicketNotFoundException e) {
						obj.setFailureMessage("Fetch Ticket is not in the List" + e.getMessage());
					}

					return obj;

				}	
				
			public TicketResponseObject fetchTicketByTicket_fare(Long Ticket_fare) throws  TicketNotFoundException {
				try {
					List<TicketVO> list;
					list = bo.fetchTicketByTicket_fare(Ticket_fare);
					obj.setTicketVOList(list);

				} catch (TicketNotFoundException e) {
					obj.setFailureMessage("Error When Fetching The Ticket Details" + e.getMessage());
				}

				return obj;

			}

			public TicketResponseObject updateTicket(TicketVO vo) throws TicketManagementException
			{
				boolean flag;
				try 
				{
					flag = bo.updateTicket(vo);
					if (flag)
						obj.setSuccessMessage("Ticket updated successfully");
					else
						obj.setFailureMessage("Error When updated Ticket Details, Reach out Administrator");
				}
				catch (TicketManagementException e){
					obj.setFailureMessage("Error When updated Ticket Details, Reach out Administrator");
				}
				return obj;
		}
}