package com.evStation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evStation.entities.ChargingStation;


@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {
}
