package org.airtribe.RideWiseApp.controller;


import jakarta.validation.Valid;
import org.airtribe.RideWiseApp.exception.DuplicateMailException;
import org.airtribe.RideWiseApp.exception.RiderNotFoundException;
import org.airtribe.RideWiseApp.model.Rider;
import org.airtribe.RideWiseApp.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RiderController {
    @Autowired
    private RiderService riderService;

    @PostMapping("/riders")
    public ResponseEntity<Rider> createRider( @Valid  @RequestBody Rider rider) throws DuplicateMailException {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(riderService.createRider(rider));
    }

    @GetMapping("/riders/{riderId}")
    public ResponseEntity<Rider> findRider (@PathVariable Long riderId) throws RiderNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(riderService.findRider(riderId));
    }
}
