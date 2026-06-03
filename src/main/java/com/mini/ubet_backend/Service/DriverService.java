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

import java.util.List;
import java.util.Set;

import static org.springframework.boot.context.properties.bind.Bindable.setOf;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
//    private final User user;
    public DriverService(
            DriverRepository driverRepository,
            UserRepository userRepository
    ){
        this.driverRepository = driverRepository;
        this.userRepository= userRepository;
    }

    @Transactional
    public DriverResponse createDriver(CreateDriverRequest createDriverRequest){
        Driver driver = new Driver();
        if(driverRepository.existsByLicenseNumber(createDriverRequest.licenseNumber())){
            throw new RuntimeException("Duplicate Driver as licenseNumber is already present");
        }
        driver.setLicenseNumber(createDriverRequest.licenseNumber());
        driver.setAvailable(true);
        driver.setRating(0.0);
        User user = new User();
        if(userRepository.existsByEmail(createDriverRequest.email())){
            throw new RuntimeException("email already Exists");
        }
        user.setName(createDriverRequest.name());

        user.setPassword(createDriverRequest.password());
        user.setEmail(createDriverRequest.email());
        user.setRoles(Set.of(Role.DRIVER));
        User savedUser = userRepository.save(user);
        driver.setUser(savedUser);
        Driver savedDriver = driverRepository.save(driver);

        return new DriverResponse(
                savedDriver.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedDriver.getLicenseNumber()
        );
    }


}
