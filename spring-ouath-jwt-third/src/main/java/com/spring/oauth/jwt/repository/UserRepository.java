package com.spring.oauth.jwt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.oauth.jwt.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}


