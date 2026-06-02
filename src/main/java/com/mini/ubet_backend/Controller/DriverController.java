package com.mini.ubet_backend.Controller;

import com.mini.ubet_backend.Repository.DriverRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("driver")
public class DriverController {



    @GetMapping
    public String test() {
        return "in the driver test";
    }
}
