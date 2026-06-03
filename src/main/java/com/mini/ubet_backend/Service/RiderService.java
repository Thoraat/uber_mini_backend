package com.mini.ubet_backend.Service;

import com.mini.ubet_backend.DTO.CreateRiderRequest;
import com.mini.ubet_backend.DTO.RiderResponse;
import com.mini.ubet_backend.Entity.Rider;
import com.mini.ubet_backend.Entity.User;
import com.mini.ubet_backend.Enum.Role;
import com.mini.ubet_backend.Repository.RiderRepository;
import com.mini.ubet_backend.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RiderService {

    private final RiderRepository riderRepository;
    private final UserRepository userRepository;

    RiderService(RiderRepository riderRepository, UserRepository userRepository){
        this.riderRepository = riderRepository;
        this.userRepository= userRepository;
    }

    @Transactional
    public RiderResponse createRider(CreateRiderRequest request) {
        Rider rider = new Rider();
        rider.setRatings(0.0);
        User  user  = new User();
        if(userRepository.existsByEmail(request.email())){
            throw new RuntimeException("User already exists");
        }
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRoles(Set.of(Role.RIDER));
        rider.setUser(user);
        User savedUser = userRepository.save(user);
        riderRepository.save(rider);

        return new RiderResponse(savedUser.getId(),savedUser.getName(),savedUser.getEmail());
    }
}
