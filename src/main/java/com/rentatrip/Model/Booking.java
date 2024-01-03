package com.rentatrip.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDateTime bookingCreatedAt;
	
	private LocalDate date ;
	
	private LocalTime time;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String origin;
	
	private String destination;
	
	private String description;
	
	private double distanceInKm;
	
	private double price;
	
	private boolean isPaid;
	
	private String methodOfpayment;
	
	public Booking() {
		
	}
	

	public Booking(long id, LocalDateTime bookingCreatedAt, LocalDate date, LocalTime time, User user, String origin,
			String destination, String description, double distanceInKm, double price, boolean isPaid,
			String methodOfpayment) {
		super();
		this.id = id;
		this.bookingCreatedAt = bookingCreatedAt;
		this.date = date;
		this.time = time;
		this.user = user;
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.distanceInKm = distanceInKm;
		this.price = price;
		this.isPaid = isPaid;
		this.methodOfpayment = methodOfpayment;
	}





	public String getOrigin() {
		return origin;
	}



	public void setOrigin(String origin) {
		this.origin = origin;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public LocalDateTime getBookingCreatedAt() {
		return bookingCreatedAt;
	}



	public void setBookingCreatedAt(LocalDateTime bookingCreatedAt) {
		this.bookingCreatedAt = bookingCreatedAt;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getMethodOfpayment() {
		return methodOfpayment;
	}

	public void setMethodOfpayment(String methodOfpayment) {
		this.methodOfpayment = methodOfpayment;
	}



	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingCreatedAt=" + bookingCreatedAt + ", date=" + date + ", time=" + time
				+ ", user=" + user + ", origin=" + origin + ", destination=" + destination + ", description="
				+ description + ", distanceInKm=" + distanceInKm + ", price=" + price + ", isPaid=" + isPaid
				+ ", methodOfpayment=" + methodOfpayment + "]";
	}



	
	

}
