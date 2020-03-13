package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.DestinationDAO;
import com.demo.exception.DestinationManagementException;
import com.demo.exception.DestinationNotFoundException;
import com.demo.vo.DestinationVO;


public class DestinationBO {
	DestinationDAO dao=new DestinationDAO();
		
		public boolean addDestination(DestinationVO vo) throws DestinationManagementException {
			try
			{
				boolean flag;
				flag=dao.addDestinationDetails(vo);
				return flag;
			}
		catch(DestinationManagementException e)
		{
			throw new DestinationManagementException("Error when adding Destination details,Reach out Adminstor"+e.getMessage());
		}
		}
		
				public DestinationVO fetchDestinationById(int Destination_id) throws DestinationNotFoundException 
		{
					DestinationVO vo=new DestinationVO();
			vo=dao.fetchDestinationById(Destination_id);
			return vo;
		}
		public List< DestinationVO> fetchDestinationByName(String Destination_name) throws DestinationNotFoundException
		{
			List<DestinationVO> list=new ArrayList<DestinationVO>();
			list= dao.fetchDestinationByName(Destination_name);
			return list;
		}
		public boolean updateDestination(DestinationVO vo) throws DestinationManagementException 
		{
			try{
				boolean flag;
				flag=dao.updateDestination(vo);
				return flag;

			}
			catch(DestinationManagementException e)
			{
				throw new DestinationManagementException("Error when adding Destination details,Reach out Adminstor"+e.getMessage());
			}
}
}
