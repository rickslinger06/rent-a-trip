package com.rentatrip.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentatrip.Model.Booking;
import com.rentatrip.Services.BookingService;

@RestController
@RequestMapping("api/v1/booking")
@CrossOrigin(origins = "http://localhost:4200") 
public class BookingController {
	
	private BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	
	@PostMapping
	public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
		
		Booking adBooking = this.bookingService.addBooking(booking);
		return ResponseEntity.ok(adBooking);
		
	}

}
