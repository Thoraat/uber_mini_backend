package com.mini.ubet_backend.Controller;

import com.mini.ubet_backend.DTO.CreateDriverRequest;
import com.mini.ubet_backend.Entity.Driver;
import com.mini.ubet_backend.Repository.DriverRepository;
import com.mini.ubet_backend.Service.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(
            DriverService driverService
    ){
        this.driverService = driverService;
    }


    @GetMapping
    public String test() {
        return "in the driver test";
    }


    @PostMapping("/register")
    public CreateDriverRequest registerDriver(@RequestBody CreateDriverRequest
                                              request){

        Driver driver = driverService.createDriver(request);
        return request;
    }
}
