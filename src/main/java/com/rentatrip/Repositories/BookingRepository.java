package com.rentatrip.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentatrip.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
