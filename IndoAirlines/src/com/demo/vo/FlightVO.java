package com.demo.vo;

import java.sql.Time;

public class FlightVO {
private int	Flight_id;
public int getFlight_id() {
	return Flight_id;
}
public void setFlight_id(int flight_id) {
	Flight_id = flight_id;
}
public String getFlight_name() {
	return Flight_name;
}
public void setFlight_name(String flight_name) {
	Flight_name = flight_name;
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
@Override
public String toString() {
	return "FlightVO [Flight_id=" + Flight_id + ", Flight_name=" + Flight_name + ", Source_id=" + Source_id
			+ ", Destination_id=" + Destination_id + ", Arrival_time=" + Arrival_time + ", Departure_time="
			+ Departure_time + ", getFlight_id()=" + getFlight_id() + ", getFlight_name()=" + getFlight_name()
			+ ", getSource_id()=" + getSource_id() + ", getDestination_id()=" + getDestination_id()
			+ ", getArrival_time()=" + getArrival_time() + ", getDeparture_time()=" + getDeparture_time() + "]";
}
public void setDestination_id(int destination_id) {
	Destination_id = destination_id;
}
public Time getArrival_time() {
	return Arrival_time;
}
public void setArrival_time(Time arrival_time) {
	Arrival_time = arrival_time;
}
public Time getDeparture_time() {
	return Departure_time;
}
public void setDeparture_time(Time departure_time) {
	Departure_time = departure_time;
}
private String Flight_name;
private int Source_id;
private int	Destination_id;
	private Time Arrival_time;
	private Time Departure_time;

}
