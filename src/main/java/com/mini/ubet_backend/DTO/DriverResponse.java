package com.mini.ubet_backend.DTO;

public record DriverResponse(
        Long Id,
        String name,
        String email,
        String licenseNumber
) {
}
