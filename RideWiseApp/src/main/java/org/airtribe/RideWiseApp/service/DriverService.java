package org.airtribe.RideWiseApp.service;


import org.airtribe.RideWiseApp.exception.DriverNotFoundException;
import org.airtribe.RideWiseApp.exception.DuplicateMailException;
import org.airtribe.RideWiseApp.model.Driver;
import org.airtribe.RideWiseApp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver (Driver driver) throws DuplicateMailException {
        if(!driverRepository.existsByDriverEmail(driver.getEmail())) {
            return driverRepository.save(driver);
        }
        throw new DuplicateMailException("Driver with email " + driver.getEmail() + " already exists");
    }

    public Driver getDriverById (Long driverId){
        if(driverRepository.findById(driverId).isPresent()) {
            return driverRepository.findById(driverId).get();
        }
        throw new DriverNotFoundException("Driver with id " + driverId + " not found");
    }

    public List<Driver> getAllDrivers() {
        if(!driverRepository.findAll().isEmpty()) {
            return driverRepository.findAll();
        }
        throw new DriverNotFoundException("Drivers not found");
    }

    public Driver updateDriverStatus(Long driverId, Driver driver){
        if(!driverRepository.findById(driverId).isPresent()) {
            throw new DriverNotFoundException("Driver with id " + driverId + " not found");
        }
        Driver updatedDriver = driverRepository.findById(driverId).get();
        updatedDriver.setStatus(driver.getStatus());
        driverRepository.save(updatedDriver);
        return updatedDriver;
    }
}
