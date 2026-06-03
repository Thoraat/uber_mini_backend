package com.mini.ubet_backend.Controller;


import com.mini.ubet_backend.DTO.CreateRiderRequest;
import com.mini.ubet_backend.DTO.RiderResponse;
import com.mini.ubet_backend.Service.RiderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rider")
public class RiderController {

    private final RiderService riderService;

    RiderController(RiderService riderService){
        this.riderService=riderService;
    }

    @GetMapping("")
    public String check(){
        return "in rider";
    }

    @PostMapping("/register")
    public RiderResponse registerRider(@Valid @RequestBody CreateRiderRequest request){
        return riderService.createRider(request);
    }
}
