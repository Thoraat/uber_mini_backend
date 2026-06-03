package com.mini.ubet_backend.Controller;

import com.mini.ubet_backend.DTO.CreateDriverRequest;
import com.mini.ubet_backend.DTO.DriverResponse;
import com.mini.ubet_backend.Entity.Driver;
import com.mini.ubet_backend.Repository.DriverRepository;
import com.mini.ubet_backend.Service.DriverService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(
            DriverService driverService
    ){
        this.driverService = driverService;
    }





    @PostMapping("/register")
    public DriverResponse registerDriver(
            @Valid  @RequestBody CreateDriverRequest request){

        DriverResponse savedDriver = driverService.createDriver(request);
        return savedDriver;
    }
}
