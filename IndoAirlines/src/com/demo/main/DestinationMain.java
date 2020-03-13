package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.DestinationManagementException;
import com.demo.exception.DestinationNotFoundException;
import com.demo.response.DestinationResponseObject;
import com.demo.service.DestinationService;
import com.demo.vo.DestinationVO;


public class DestinationMain {

	public static void main(String[] args) throws DestinationManagementException, DestinationNotFoundException {
		
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Destination");
		System.out.println("2. Fetch Destination by Destination_id");
		System.out.println("3. Fetch Destination by Destination_name");
		System.out.println("4. Update Destination Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addDestinationDetail();
			break;
		case 2:
			fetchDestinationById();
			break;
		case 3:
			fetchDestinationByName();
			break;
		case 4:
			updateDestinationDetail();
			break;
		default:
			System.exit(0);
		}
	}

			private static void addDestinationDetail() throws DestinationManagementException {
			DestinationService destinationService = new DestinationService();
			Scanner s = new Scanner(System.in);
			boolean flag;
			System.out.println("Please Enter The Destination_id:");
			Integer Destination_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The Destination_name:");
			String Destination_name= s.nextLine();
			DestinationVO vo = new DestinationVO();
			vo.setDestination_id(Destination_id);
			vo.setDestination_name(Destination_name);
			DestinationResponseObject obj=null ;
			obj = destinationService.addDestination(vo);
			if (obj.getSuccessMessage() != null) {
				System.out.println(obj.getSuccessMessage());
			} else {
				System.out.println(obj.getFailureMessage());
			}
			}

			private static void fetchDestinationById() throws DestinationNotFoundException {
				// TODO Auto-generated method stub
					Scanner s = new Scanner(System.in);
					System.out.println("Please Enter The Destination ID:");
					Integer Destination_id = Integer.parseInt(s.nextLine());
					DestinationService destinationService = new DestinationService();
					DestinationResponseObject obj = destinationService.fetchDestinationById(Destination_id);
					DestinationVO vo;
					vo = obj.getDestinationVo();
					if (vo != null) {
						System.out.println(
								"================================================================================================");
						System.out.println("DestinationId" + '\t' + "Destination_Name" + '\t');
						System.out.println(
								"================================================================================================");
						System.out.println(vo.getDestination_id() + "\t\t" 
								+ vo.getDestination_name());

					} else {
						System.out.println(obj.getFailureMessage());
					}
			}

					private static void fetchDestinationByName() throws DestinationNotFoundException {
						// TODO Auto-generated method stub
							Scanner s = new Scanner(System.in);
							System.out.println("Please Enter The Destination_name:");
							String Destination_name =s.nextLine();
							DestinationService destinationService = new DestinationService();
							DestinationResponseObject obj = null;
							obj = destinationService.fetchDestinationByName(Destination_name);
							DestinationVO vo = new DestinationVO();
							List<DestinationVO> list = new ArrayList<DestinationVO>();
							list = obj.getDestinationVOList();
							if (list != null)

							{
								System.out.println(
										"================================================================================================");
								System.out.println("DestinationId" + '\t' + "Destinationname" + '\t' );
								System.out.println(
										"================================================================================================");
								System.out.println(vo.getDestination_id() + "\t\t" + vo.getDestination_name() );
							} else {
								System.out.println(obj.getFailureMessage());
							}

					}

		private static void updateDestinationDetail() throws DestinationManagementException {
		
		DestinationService destinationService = new DestinationService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Destination_id:");
		Integer Destination_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Destination_name:");
		String Destination_name = s.nextLine();
		DestinationVO vo = new DestinationVO();
		vo.setDestination_id(Destination_id);
		vo.setDestination_name(Destination_name);
		DestinationResponseObject obj = null;
		obj = destinationService.updateDestination(vo);
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


