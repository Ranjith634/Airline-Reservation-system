package com.demo.vo;

import java.sql.Date;

public class TicketVO {
	private int Ticket_id;
	private int Reg_id;
	private int Source_id;
	@Override
	public String toString() {
		return "TicketVO [Ticket_id=" + Ticket_id + ", Reg_id=" + Reg_id + ", Source_id=" + Source_id
				+ ", Destination_id=" + Destination_id + ", Departure_date=" + Departure_date + ", Return_date="
				+ Return_date + ", Ticket_fare=" + Ticket_fare + ", getTicket_id()=" + getTicket_id() + ", getReg_id()="
				+ getReg_id() + ", getSource_id()=" + getSource_id() + ", getDestination_id()=" + getDestination_id()
				+ ", getDeparture_date()=" + getDeparture_date() + ", getReturn_date()=" + getReturn_date()
				+ ", getTicket_fare()=" + getTicket_fare() + "]";
	}
	public int getTicket_id() {
		return Ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		Ticket_id = ticket_id;
	}
	public int getReg_id() {
		return Reg_id;
	}
	public void setReg_id(int reg_id) {
		Reg_id = reg_id;
	}
	public int getSource_id() {
		return Source_id;
	}
	public void setSource_id(int source_id) {
		Source_id = source_id;
	}
	public int getDestination_id() {
		return Destination_id;
	}
	public void setDestination_id(int destination_id) {
		Destination_id = destination_id;
	}
	public Date getDeparture_date() {
		return Departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		Departure_date = departure_date;
	}
	public Date getReturn_date() {
		return Return_date;
	}
	public void setReturn_date(Date return_date) {
		Return_date = return_date;
	}
	public Long getTicket_fare() {
		return Ticket_fare;
	}
	public void setTicket_fare(Long ticket_fare) {
		Ticket_fare = ticket_fare;
	}
	private int Destination_id;
	private Date Departure_date;
	private Date Return_date;
	private Long Ticket_fare;

}