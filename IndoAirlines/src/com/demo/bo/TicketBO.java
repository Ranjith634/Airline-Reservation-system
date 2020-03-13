package com.demo.bo;


import java.util.ArrayList;
import java.util.List;

import com.demo.dao.TicketDAO;
import com.demo.exception.TicketManagementException;
import com.demo.exception.TicketNotFoundException;
import com.demo.vo.TicketVO;

public class TicketBO {
		TicketDAO dao=new TicketDAO();
		
		public boolean addTicket(TicketVO vo) throws  TicketManagementException
		{
			try
			{
			boolean flag;
			flag=dao.addTicketDetails(vo);
			return flag;
			}
			catch(TicketManagementException e)
			{
				throw new TicketManagementException("Error when adding ticket details"+e.getMessage());
			}
					
		}
				public TicketVO fetchTicketById(int Ticket_id) throws TicketNotFoundException
		{
			
					try{
						TicketVO vo=new TicketVO();
			vo=dao.fetchTicketById(Ticket_id);
			return vo;}
					catch(TicketNotFoundException e)
					{
						throw new TicketNotFoundException("Error when fetching "+e.getMessage());
					}
		}
		public List< TicketVO> fetchTicketByTicket_fare(Long Ticket_fare) throws  TicketNotFoundException
		{
			List<TicketVO> list=new ArrayList<TicketVO>();
			list=dao.fetchTicketByTicket_fare(Ticket_fare);			
			return list;
		}
		public boolean updateTicket(TicketVO vo) throws TicketManagementException{
		try
		{
			boolean flag;
			flag=dao.updateTicketDetails(vo);
			return flag;
			
		
}catch(TicketManagementException e)
{
	throw new TicketManagementException("Error when adding ticket details"+e.getMessage());
}
		
		}
}
