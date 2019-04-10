package com.spring.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.oauth.entity.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
