package com.evStation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evStation.entities.ChargingStation;
import com.evStation.services.ChargingStationService;

@RestController
@RequestMapping("/charging_stations")
public class ChargingStationController {
	
	@Autowired
	private ChargingStationService stationService;

	
	// GET request to list all charging stations
	@GetMapping("/")
	public List<ChargingStation> getStations(@RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "param", required = false) String param){
		
		if(sort != null & param != null) {
			return this.stationService.listAllChargingStations(sort, param);
		} else if (limit != null) {
			if(limit < 10)limit = 10;
			return this.stationService.listAllChargingStations(limit);
		} else {		
			return this.stationService.listAllChargingStations();
		}
	}
	
	
	
	// GET request to show single charging station details
	@GetMapping("/show/{id}")
	public ChargingStation getStation(@PathVariable String id){
		return this.stationService.showChargingStationDetails(Long.parseLong(id));
	}
	
	// POST request to add charging station details
	@PostMapping("/")
	public ChargingStation addStations(@RequestBody ChargingStation chargingStation){
		return this.stationService.addChargingStation(chargingStation);
	}
	
	// PUT request to edit charging station details
	@PutMapping("/{id}/edit")
	public ChargingStation updateStation(@PathVariable String id, @RequestBody ChargingStation chargingStation) {
		return this.stationService.editChargingStation(Long.parseLong(id), chargingStation);
	}
	
	
	// DELETE request to delete charging station
	@DeleteMapping("/delete/{id}")
	public void DeleteStation(@PathVariable String id){
		this.stationService.deleteChargingStation(Long.parseLong(id));
	}
	
	
}
