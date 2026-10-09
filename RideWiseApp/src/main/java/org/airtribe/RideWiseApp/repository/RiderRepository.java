package org.airtribe.RideWiseApp.repository;


import org.airtribe.RideWiseApp.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {

 boolean existsByEmail (String email);
}
