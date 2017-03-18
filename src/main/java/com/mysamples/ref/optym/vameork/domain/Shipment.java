package com.mysamples.ref.optym.vameork.domain;

import java.util.Calendar;

public class Shipment {
	private String origin;
	private String destination;
	private Calendar shipmentDate;
	private double weight;
	private long cube;
	private ShipmentServiceTypesEnum serviceTypes;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Calendar getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Calendar shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public long getCube() {
		return cube;
	}
	public void setCube(long cube) {
		this.cube = cube;
	}
	public ShipmentServiceTypesEnum getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(ShipmentServiceTypesEnum serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	

}
