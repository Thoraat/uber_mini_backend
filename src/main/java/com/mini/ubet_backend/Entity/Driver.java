package com.mini.ubet_backend.Entity;

import com.mini.ubet_backend.DTO.CreateDriverRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drivers")
@Data
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseNumber;

    private Double rating;

    private boolean available;

    @OneToOne
    private User user;


}
