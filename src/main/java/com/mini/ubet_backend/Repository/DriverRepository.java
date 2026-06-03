package com.mini.ubet_backend.Repository;

import com.mini.ubet_backend.Entity.Driver;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    boolean existsByLicenseNumber(@NotBlank String s);
}
