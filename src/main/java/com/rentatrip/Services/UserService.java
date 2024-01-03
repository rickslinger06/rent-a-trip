package com.rentatrip.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rentatrip.Exceptions.UserNotFoundException;
import com.rentatrip.Model.User;
import com.rentatrip.Repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	

	
	public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	public User getUserByEmail(String email) {

		return this.userRepo.findByEmail(email);
	}

	public List<User> getAllUsers() throws UserNotFoundException {
	    return Optional.ofNullable(userRepo.findAll())
	            .orElseThrow(() -> new UserNotFoundException("No users found"));
	}

	public User addUser(User user) {
		
		
		user.setUsername(user.getEmail());
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		
		User newUser = this.userRepo.save(user);
		
		return newUser;
	}
	
	
	public boolean userExistsByUsername(String username) throws UserNotFoundException {

		if (!userRepo.existsByUsername(username)) {
			throw new UserNotFoundException("User doesnt exists");
		}
		return userRepo.existsByUsername(username);
	}
	
	public boolean existByEmail(String email) {
		return this.userRepo.existsByEmail(email);
	}
	
	public boolean existsByUsername(String username) {

		return this.userRepo.existsByUsername(username);
	}
	
	
	
	public User updateUser(long id, User updatedUser) throws UserNotFoundException {
	    User existingUser = this.userRepo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " could not be found."));

	    // Update the properties of the existing user with the data from updatedUser
	    existingUser.setName(updatedUser.getName());
	    existingUser.setEmail(updatedUser.getEmail());
	    existingUser.setUsername(updatedUser.getUsername());
	    existingUser.setPicByte(updatedUser.getPicByte());
	    existingUser.setAddress(updatedUser.getAddress());
	    existingUser.setAccountType(updatedUser.getAccountType());
	    existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
	
	    return this.userRepo.save(existingUser);
	}


	public void deleteUser(long id) throws UserNotFoundException {

			if (!this.userRepo.existsById(id)) {
				throw new UserNotFoundException("Contact with id " + id + " could not be found.");
			}
			// Delete the user
			this.userRepo.deleteById(id);
		}
	
	public boolean login(String username, String password) {
		if (userRepo.existsByUsernameAndPassword(username, password)) {
			return true;
		}
		return false;
	}

	public User findUserByUsername(String username) throws UserNotFoundException {
		
		User foundUser = userRepo.findByUsername(username);
		
		if(foundUser == null) {
			throw new UserNotFoundException(username + "could not be found");
		}
		return foundUser;
	}
	
	
	}
	

	

