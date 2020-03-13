package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.FlightManagementException;
import com.demo.exception.FlightNotFoundException;
import com.demo.response.FlightResponseObject;
import com.demo.service.FlightService;
import com.demo.vo.FlightVO;

public class FlightMain {

	public static void main(String[] args) throws FlightManagementException, FlightNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Flight");
		System.out.println("2. Fetch Flight by Flight_id");
		System.out.println("3. Fetch Flight by Flight_name");
		System.out.println("4. Update Flight Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addFlightDetail();
			break;
		case 2:
			fetchFlightById();
			break;
		case 3:
			fetchFlightByName();
			break;
		case 4:
			updateFlightDetail();
			break;
		default:
			System.exit(0);
		}
	}	
	


	private static void addFlightDetail() throws FlightManagementException {
		FlightService flightService = new FlightService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Flight_id:");
		Integer Flight_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Flight_name:");
		String Flight_name= String.valueOf(s.nextLine());
		FlightVO vo = new FlightVO();
		vo.setFlight_id(Flight_id);
		vo.setFlight_name(Flight_name);
		FlightResponseObject obj=null ;
		obj = flightService.addFlight(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	private static void fetchFlightById() throws FlightNotFoundException, FlightManagementException {

		// TODO Auto-generated method stub // TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Flight ID:");
		Integer Flight_id = Integer.parseInt(s.nextLine());
		FlightService flightService = new FlightService();
		FlightResponseObject obj = flightService.fetchFlightById(Flight_id);
		FlightVO vo = new FlightVO();
		vo = obj.getFlightVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("FlightId" + '\t' + "Flightname" + '\t' + "Sourceid" + '\t' + " Destination_id" + '\t'
					+ "Arrival_time" + '\t' + "Departure_time" + '\t' );
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getFlight_id() + "\t\t" + vo.getFlight_name() + "\t\t" + vo.getSource_id() + "\t\t"
					+ vo.getDestination_id() + vo.getArrival_time() + "\t\t" + vo.getDeparture_time() + "\t\t");
					

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchFlightByName() throws FlightNotFoundException {

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Flight_Name:");
		String Flight_Name =String.valueOf(s.nextLine());
		FlightService flightService = new FlightService();
		FlightResponseObject obj = null;
		obj = flightService.fetchFlightByName(Flight_Name);
		FlightVO vo = new FlightVO();
		List<FlightVO> list = new ArrayList<FlightVO>();
		list = obj.getFlightList();
		if (list != null)

		{
			System.out.println(
					"================================================================================================");
			System.out.println("FlightId" + '\t' + "Flightname" + '\t' + "Sourceid" + '\t' + " Destination_id" + '\t'
					+ "Arrival_time" + '\t' + "Departure_time" + '\t');
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getFlight_id() + "\t\t" + vo.getFlight_name()+ "\t\t" + vo.getSource_id() + "\t\t"
					+ vo.getDestination_id() + "\t\t" + vo.getArrival_time() + "\t\t" + vo.getDeparture_time() + "\t\t");
		} else {
			System.out.println(obj.getFailureMessage());
		}
		return;

	} // TODO Auto-generated method stub


	private static void updateFlightDetail() throws FlightManagementException {
		FlightService flightservice = new FlightService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Flight_id:");
		Integer Flight_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Flight_name:");
		String Flight_name = String.valueOf(s.nextLine());
		FlightVO vo = new FlightVO();
		vo.setFlight_id(Flight_id);
		vo.setFlight_name(Flight_name);
		FlightResponseObject obj=null;
		obj = flightservice.updateFlight(vo);
		if (obj.getSuccessMessage() != null)
		{
			System.out.println(obj.getSuccessMessage());
		}
		else
		{
			System.out.println(obj.getFailureMessage());
		}
	
}

		}


