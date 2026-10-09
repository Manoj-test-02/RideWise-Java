package org.airtribe.RideWiseApp.repository;

import org.airtribe.RideWiseApp.model.Driver;
import org.airtribe.RideWiseApp.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    boolean existsByDriverEmail (String driverEmail);
}
