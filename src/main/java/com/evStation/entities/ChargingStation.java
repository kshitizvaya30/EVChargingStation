package com.evStation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charging_station")
public class ChargingStation {

	@Override
	public String toString() {
		return "ChargingStation [stationId=" + stationId + ", stationName=" + stationName + ", stationImageUrl="
				+ stationImageUrl + ", stationPricing=" + stationPricing + ", stationAddress=" + stationAddress + "]";
	}
	
	
	public ChargingStation(long stationId, String stationName, String stationImageUrl, int stationPricing,
		String stationAddress) {
	super();
	this.stationId = stationId;
	this.stationName = stationName;
	this.stationImageUrl = stationImageUrl;
	this.stationPricing = stationPricing;
	this.stationAddress = stationAddress;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "station_id")
	private long stationId;
	
	

	@Column(name = "station_name", nullable = false)
	private String stationName;
	
	@Column(name = "station_image_url", nullable = false)
	private String stationImageUrl;
	
	@Column(name = "station_pricing", nullable = false)
	private int stationPricing;
	
	@Column(name = "station_address", nullable = false)
	private String stationAddress;
	
	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationImageUrl() {
		return stationImageUrl;
	}

	public void setStationImageUrl(String stationImageUrl) {
		this.stationImageUrl = stationImageUrl;
	}

	public int getStationPricing() {
		return stationPricing;
	}

	public void setStationPricing(int stationPricing) {
		this.stationPricing = stationPricing;
	}

	public String getStationAddress() {
		return stationAddress;
	}

	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}

	public ChargingStation() {
		super();
	}
}
