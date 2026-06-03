package com.mini.ubet_backend.Service;

import com.mini.ubet_backend.DTO.CreateDriverRequest;
import com.mini.ubet_backend.DTO.DriverResponse;
import com.mini.ubet_backend.Entity.Driver;
import com.mini.ubet_backend.Entity.User;
import com.mini.ubet_backend.Enum.Role;
import com.mini.ubet_backend.Repository.DriverRepository;
import com.mini.ubet_backend.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
    public DriverService(
            DriverRepository driverRepository,
            UserRepository userRepository
    ){
        this.driverRepository = driverRepository;
        this.userRepository= userRepository;
    }

    @Transactional
    public DriverResponse createDriver(CreateDriverRequest createDriverRequest){
        User user ;
        if(userRepository.existsByEmail(createDriverRequest.email())){
            user = userRepository.findByEmail(createDriverRequest.email());
            if(user.getRoles().contains(Role.DRIVER)){
                throw new RuntimeException("User Already exists");
            }
            user.getRoles().add(Role.DRIVER);
        }
        else{
            user = new User();
            user.setName(createDriverRequest.name());
            user.setPassword(createDriverRequest.password());
            user.setEmail(createDriverRequest.email());
            user.setRoles(new HashSet<>(Set.of(Role.DRIVER)));
        }
        Driver driver = new Driver();
        if(driverRepository.existsByLicenseNumber(createDriverRequest.licenseNumber())){
            throw new RuntimeException("Duplicate Driver as licenseNumber is already present");
        }
        driver.setLicenseNumber(createDriverRequest.licenseNumber());
        driver.setAvailable(true);
        driver.setRating(0.0);
        driver.setUser(user);

        User savedUser = userRepository.save(user);
        Driver savedDriver = driverRepository.save(driver);

        return new DriverResponse(
                savedDriver.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedDriver.getLicenseNumber()
        );
    }


}
