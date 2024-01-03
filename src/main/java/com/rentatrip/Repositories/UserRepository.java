package com.rentatrip.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentatrip.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByUsername(String username);
	

	boolean existsByUsername(String username);

	boolean existsByUsernameAndPassword(String username, String password);

	boolean existsByEmail(String email);


}
