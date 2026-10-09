package org.airtribe.RideWiseApp.service;

import org.airtribe.RideWiseApp.exception.DuplicateMailException;
import org.airtribe.RideWiseApp.exception.RiderNotFoundException;
import org.airtribe.RideWiseApp.model.Rider;
import org.airtribe.RideWiseApp.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
public class RiderService {

    @Autowired
    private RiderRepository riderRepository;


    public Rider createRider(Rider rider) throws DuplicateMailException {
        if(!riderRepository.existsByEmail(rider.getEmail())) {
            return riderRepository.save(rider);
        }
        throw new DuplicateMailException("Email already in use.");
    }

    public Rider findRider(Long riderId) throws RiderNotFoundException {
        if(riderRepository.findById(riderId).isPresent()){
            return riderRepository.findById(riderId).get();
        }
        throw new RiderNotFoundException("Rider not found. Rider id: " + riderId);

    }


}
