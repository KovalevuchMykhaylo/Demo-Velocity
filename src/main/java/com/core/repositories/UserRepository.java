package com.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.core.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
