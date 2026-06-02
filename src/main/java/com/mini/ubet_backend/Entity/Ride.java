package com.mini.ubet_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rides")
@Data
@NoArgsConstructor
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
