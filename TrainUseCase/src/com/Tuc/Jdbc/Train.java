package com.Tuc.Jdbc;

public class Train {
	private int trainNo;
	private String trainName;
	private String source;
	private String destination;
	private double ticketPrice;
	public int getTrainNo() {
		return trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", trainName=" + trainName + ", source=" + source + ", destination="
				+ destination + ", ticketPrice=" + ticketPrice + "]";
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
