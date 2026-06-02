package com.mini.ubet_backend.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String pickupLocation;

    private String dropLocation;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Rider rider;

}
