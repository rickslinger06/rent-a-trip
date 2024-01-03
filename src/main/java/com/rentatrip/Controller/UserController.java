package com.rentatrip.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rentatrip.Exceptions.UserNotFoundException;
import com.rentatrip.Model.User;
import com.rentatrip.Model.UserDTO;
import com.rentatrip.Security.AuthenticationResponse;
import com.rentatrip.Security.JwtTokenUtil;
import com.rentatrip.Security.JwtUserDetailsService;
import com.rentatrip.Services.UserService;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://localhost:4200") 
public class UserController {
	
	private UserService userService;
	
	private JwtUserDetailsService userDetailsService;

	private JwtTokenUtil jwtTokenUtil;

	private AuthenticationManager authenticationManager;

	


	public UserController(UserService userService, JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.userService = userService;
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
		this.authenticationManager = authenticationManager;
	}

	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable String email) {
		
		return this.userService.getUserByEmail(email);
		
	}
	
	@GetMapping("/all")
		public List<User> getAllUsers() throws UserNotFoundException {
			
		return Optional.ofNullable(this.userService.getAllUsers())
				.orElseThrow( () -> new UserNotFoundException("user not found"));
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		User newUser = this.userService.addUser(user);
		
		return ResponseEntity.ok(newUser);
		
	}
	
	
	@GetMapping("/users/{username}")
	public ResponseEntity<Boolean> usernameExists(@PathVariable String username) {
		boolean exists = userService.existsByUsername(username);
		return ResponseEntity.ok(exists);
	}

	@GetMapping("/user/{email}")
	public ResponseEntity<Boolean> emailExists(@PathVariable String email) {
		boolean exists = userService.existByEmail(email);
		return ResponseEntity.ok(exists);
	}




	@DeleteMapping("/id/{id}")
	public void deleteUserById(@PathVariable long id) throws UserNotFoundException {
		this.userService.deleteUser(id);
	}

	@PutMapping("/id/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) throws UserNotFoundException {
	
		return this.userService.updateUser(id, user);
	}
	
//	
//	@GetMapping("/username/{username}")
//	public User getUserByUsername(@PathVariable String username) throws UserNotFoundException {
//
//		User user = this.userService.findUserByUsername(username);
//		if (user == null) {
//			throw new UserNotFoundException("Username could not be found" + username);
//		}
//
//		return user;
//
//	}
		
	
	@GetMapping("/username/{username}")
	public UserDTO checkUsername(@PathVariable String username) throws UserNotFoundException {

		User user = this.userService.findUserByUsername(username);
		return new UserDTO(user.getId(), user.getName(),user.getEmail(),user.getUsername(), 
			 user.getPicByte(), user.getAddress(),user.getAccountType(), user.getPhoneNumber(),user.getResetToken(),user.getTokenCreateTime());

	}
		
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println("called 1");
	    try {
	        authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

	        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	        final String token = jwtTokenUtil.generateToken(userDetails);
	        
	   
	   
	        return ResponseEntity.ok(new AuthenticationResponse(token));
	    } catch (BadCredentialsException ex) {
	        System.out.println("not authenticated");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
	    }
	}

	


}
