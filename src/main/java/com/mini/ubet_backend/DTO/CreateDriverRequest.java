package com.mini.ubet_backend.DTO;

public record CreateDriverRequest(
        String name,
        String email,
        String password,
        String licenseNumber
) {
}
