package com.evStation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.evStation.dao.ChargingStationRepository;
import com.evStation.entities.ChargingStation;


@Service
public class StationServiceImpl implements ChargingStationService {
	
	@Autowired
    private ChargingStationRepository chargingStationRepository;
	
	
	@Override
	public List<ChargingStation> listAllChargingStations() {
        return chargingStationRepository.findAll();
    }
	
	@Override
	public List<ChargingStation> listAllChargingStations(int limit) {
		Pageable pageable = PageRequest.of(0, limit);
	    return chargingStationRepository.findAll(pageable).getContent();
	}

	@Override
	public List<ChargingStation> listAllChargingStations(String sort, String param) {
//		System.out.println("in here ::::: " + param);
		if (sort != null && param != null) {
	        Sort.Direction direction = Sort.Direction.ASC;
	        if (sort.equalsIgnoreCase("desc")) {
	            direction = Sort.Direction.DESC;
	        }
	        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, direction, param);
	        return chargingStationRepository.findAll(pageable).getContent();
	    } else {
	        return chargingStationRepository.findAll();
	    }
	}
	
	@Override
    public ChargingStation showChargingStationDetails(Long id) {
        return chargingStationRepository.findById(id).orElse(null);
    }

	@Override
	public ChargingStation addChargingStation(ChargingStation station) {
		return chargingStationRepository.save(station);
	}


	@Override
	public ChargingStation editChargingStation(long id , ChargingStation station) {
		 ChargingStation existingChargingStation = chargingStationRepository.findById(id).orElse(null);
	        if (existingChargingStation != null) {
	            existingChargingStation.setStationName(station.getStationName());
	            existingChargingStation.setStationImageUrl(station.getStationImageUrl());
	            existingChargingStation.setStationPricing(station.getStationPricing());
	            existingChargingStation.setStationAddress(station.getStationAddress());
	            return chargingStationRepository.save(existingChargingStation);
	        }
	        return null;
	}


	@Override
	public void deleteChargingStation(long id) {
		chargingStationRepository.deleteById(id);
	}

	


}
