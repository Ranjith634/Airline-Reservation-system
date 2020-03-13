package com.demo.vo;

public class DestinationVO {
private int	Destination_id;
public int getDestination_id() {
	return Destination_id;
}
public void setDestination_id(int destination_id) {
	Destination_id = destination_id;
}
public String getDestination_name() {
	return Destination_name;
}
public void setDestination_name(String destination_name) {
	Destination_name = destination_name;
}
private String Destination_name;
@Override
public String toString() {
	return "DestinationVO [Destination_id=" + Destination_id + ", Destination_name=" + Destination_name
			+ ", getDestination_id()=" + getDestination_id() + ", getDestination_name()=" + getDestination_name() + "]";
}
}
