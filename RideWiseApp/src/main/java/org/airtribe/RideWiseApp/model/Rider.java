package org.airtribe.RideWiseApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.airtribe.RideWiseApp.service.RiderService;


@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long riderId;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotNull
    @NotEmpty
    private String phone;
    private double latitude;
    private double longitude;

    public Rider(Long riderId, String name, String email, String phone, double latitude, double longitude) {
        this.riderId = riderId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Rider() {}

    public Long getRiderId() {
        return riderId;
    }

    public void setRiderId(Long id) {
        this.riderId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
