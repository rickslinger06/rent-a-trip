package com.rentatrip.Services;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.rentatrip.Model.Booking;
import com.rentatrip.Repositories.BookingRepository;

@Service
public class BookingService {
	
	private BookingRepository bookingRepo;
	
	

	public BookingService(BookingRepository bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}




	public Booking addBooking(Booking booking) {
	     ZoneId userTimeZone = ZoneId.systemDefault();
	        ZonedDateTime now = ZonedDateTime.now(userTimeZone);
	       booking.setBookingCreatedAt(now.toLocalDateTime());
		
		return   this.bookingRepo.save(booking);
	}




	@Override
	public String toString() {
		return "BookingService [bookingRepo=" + bookingRepo + "]";
	}


	

}
