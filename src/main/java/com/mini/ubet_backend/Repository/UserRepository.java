package com.mini.ubet_backend.Repository;

import com.mini.ubet_backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
