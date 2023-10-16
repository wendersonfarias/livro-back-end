package com.wenderson.java.back.end.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wenderson.java.back.end.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByCpf(String cpf);
}
