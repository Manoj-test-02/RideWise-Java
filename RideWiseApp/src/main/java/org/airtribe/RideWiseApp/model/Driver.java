package org.airtribe.RideWiseApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverId;

    @NotNull
    @NotEmpty
    private String driverName;

    @Column(unique = true)
    @NotEmpty
    @NotNull
    private String driverEmail;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    private boolean status;

    public Driver(Long driverId, String driverName, String driverEmail, double latitude, double longitude, boolean status) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverEmail = driverEmail;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    public Driver () {}

    public Long getId() {
        return driverId;
    }

    public void setId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return driverName;
    }

    public void setName(String name) {
        this.driverName = driverName;
    }

    public String getEmail() {
        return driverEmail;
    }

    public void setEmail(String email) {
        this.driverEmail = driverEmail;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
