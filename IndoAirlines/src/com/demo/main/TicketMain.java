package com.demo.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.TicketManagementException;
import com.demo.exception.TicketNotFoundException;
import com.demo.response.TicketResponseObject;
import com.demo.service.TicketService;
import com.demo.vo.TicketVO;

public class TicketMain {

	public static void main(String[] args) throws TicketManagementException, TicketNotFoundException {

		System.out.println("Please select one of the below options");
		System.out.println("1. Add Ticket");
		System.out.println("2. Fetch Ticket by Ticket_id");
		System.out.println("3. Fetch Ticket by Ticket_fare");
		System.out.println("4. Update Ticket Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addTicketDetails();
			break;
		case 2:
			fetchTicketById();
			break;
		case 3:
			fetchTicketByTicket_fare();
			break;
		case 4:
			updateTicketDetail();
			break;
		default:
			System.exit(0);
		}
	}

	private static void addTicketDetails() throws TicketManagementException {
		TicketService ticketService = new TicketService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Ticket _id:");
		Integer Ticket_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Reg_id:");
		Integer Reg_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Source_id:");
		Integer Source_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Destination_id:");
		Integer Destination_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Departure_date:");
		java.sql.Date Departure_date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Return_date:");
		java.sql.Date Return_date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Ticket_fare:");
		Long ticket_fare = Long.parseLong(s.nextLine());

		TicketVO vo = new TicketVO();

		vo.setTicket_id(Ticket_id);
		vo.setReg_id(Reg_id);
		vo.setSource_id(Source_id);
		vo.setDestination_id(Destination_id);
		vo.setDeparture_date(Departure_date);
		vo.setReturn_date(Return_date);
		vo.setTicket_fare(ticket_fare);
		TicketResponseObject obj =null;
		obj=ticketService.addTicket(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTicketById() throws TicketNotFoundException {

		// TODO Auto-generated method stub // TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Ticket ID:");
		Integer Ticket_id = Integer.parseInt(s.nextLine());
		TicketService ticketService = new TicketService();
		TicketResponseObject obj = ticketService.fetchTicketById(Ticket_id);
		TicketVO vo = new TicketVO();
		vo = obj.getTicketVo();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("TicketId" + '\t' + "Regid" + '\t' + "Sourceid" + '\t' + " Destination_id" + '\t'
					+ "Departure_date" + '\t' + "Return_date" + '\t' + "Ticket_fare" + '\t');
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getTicket_id() + "\t\t" + vo.getReg_id() + "\t\t" + vo.getSource_id() + "\t\t"
					+ vo.getDestination_id() + vo.getDeparture_date() + "\t\t" + vo.getReturn_date() + "\t\t"
					+ vo.getTicket_fare());

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTicketByTicket_fare() throws TicketNotFoundException {

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Ticket_fare:");
		Long Ticket_fare =Long.parseLong(s.nextLine());
		TicketService ticketService = new TicketService();
		TicketResponseObject obj = null;
		obj = ticketService.fetchTicketByTicket_fare(Ticket_fare);
		TicketVO vo = new TicketVO();
		List<TicketVO> list = new ArrayList<TicketVO>();
		list = obj.getTicketVOList();
		if (list != null)

		{
			System.out.println(
					"================================================================================================");
			System.out.println("TicketId" + '\t' + "Regid" + '\t' + "Sourceid" + '\t' + " Destination_id" + '\t'
					+ "Departure_date" + '\t' + "Return_date" + '\t' + "Ticket_fare" + '\t');
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getTicket_id() + "\t\t" + vo.getReg_id() + "\t\t" + vo.getSource_id() + "\t\t"
					+ vo.getDestination_id() + "\t\t" + vo.getDeparture_date() + "\t\t" + vo.getReturn_date() + "\t\t"
					+ vo.getTicket_fare() + "\t\t");
		} else {
			System.out.println(obj.getFailureMessage());
		}


	} // TODO Auto-generated method stub

	private static void updateTicketDetail() throws TicketManagementException {
		TicketService ticketService = new TicketService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Ticket _id:");
		Integer Ticket_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Reg_id:");
		Integer Reg_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Source_id:");
		Integer Source_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Destination_id:");
		Integer Destination_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Departure_date:");
		Date Departure_date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Return_date:");
		Date Return_date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Ticket_fare:");
		Long Ticket_fare = Long.valueOf(s.nextLine());
		TicketVO vo = new TicketVO();

		vo.setTicket_id(Ticket_id);
		vo.setReg_id(Reg_id);
		vo.setSource_id(Source_id);
		vo.setDestination_id(Destination_id);
		vo.setDeparture_date(Departure_date);
		vo.setReturn_date(Return_date);
		vo.setTicket_fare(Ticket_fare);
		TicketResponseObject obj = null;
		obj = ticketService.updateTicket(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
}