package org.airtribe.RideWiseApp.controller;

import jakarta.validation.Valid;
import org.airtribe.RideWiseApp.exception.DuplicateMailException;
import org.airtribe.RideWiseApp.model.Driver;
import org.airtribe.RideWiseApp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/drivers")
    public ResponseEntity<Driver> createRider( @Valid @RequestBody Driver driver) throws DuplicateMailException {
       return ResponseEntity.status(HttpStatus.OK).body(driverService.createDriver(driver));
    }

    @GetMapping("/drivers/{driverId}")
    public ResponseEntity<Driver> findDriverById(@PathVariable Long driverId){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.getDriverById(driverId));
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> findDrivers(){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.getAllDrivers());
    }

    @PutMapping("/drivers/{driverId}")
    public ResponseEntity<Driver> updateDriverStatus(@PathVariable Long driverId, @Valid @RequestBody Driver driver){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.updateDriverStatus(driverId, driver));

    }
}
