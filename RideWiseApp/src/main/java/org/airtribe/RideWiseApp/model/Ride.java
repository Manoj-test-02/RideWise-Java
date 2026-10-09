package org.airtribe.RideWiseApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rideId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @NotNull
    private double distance;

    @NotNull
    private RideStatus rideStatus;

    public Ride(Long rideId, Rider rider, Driver driver, double distance, RideStatus rideStatus) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.rideStatus = rideStatus;
    }

    public Ride() {}

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
