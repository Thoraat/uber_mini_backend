package com.mini.ubet_backend.Entity;

import com.mini.ubet_backend.Enum.RideStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name ="riders")
@Data
@NoArgsConstructor
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double ratings;

    @OneToOne
    private User user;


}
