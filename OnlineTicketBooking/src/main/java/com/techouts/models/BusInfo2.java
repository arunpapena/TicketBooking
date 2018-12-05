package com.techouts.models;

import java.io.Serializable;

public class BusInfo2 implements Serializable {

	private int busNo;
	private String busName;
	private String sourceStn;
	private String arrivalTime;
	private String destinationStn;
	private String departureTime;
	private int price;
	private SourceDestination sourceDestination;
	public SourceDestination getSourceDestination() {
		return sourceDestination;
	}
	public void setSourceDestination(SourceDestination sourceDestination) {
		this.sourceDestination = sourceDestination;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSourceStn() {
		return sourceStn;
	}
	public void setSourceStn(String sourceStn) {
		this.sourceStn = sourceStn;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDestinationStn() {
		return destinationStn;
	}
	public void setDestinationStn(String destinationStn) {
		this.destinationStn = destinationStn;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
