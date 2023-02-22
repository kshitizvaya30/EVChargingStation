package com.evStation.services;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.evStation.entities.ChargingStation;

@Repository
public interface ChargingStationService {
	public List<ChargingStation> listAllChargingStations();
	
	public List<ChargingStation> listAllChargingStations(int limit);

	public List<ChargingStation> listAllChargingStations(String sort, String param);
		
	ChargingStation showChargingStationDetails(Long id);

	public ChargingStation addChargingStation(ChargingStation chargingStation);

	ChargingStation editChargingStation(long id, ChargingStation chargingStation);
	
	public void deleteChargingStation(long stationId);

}
