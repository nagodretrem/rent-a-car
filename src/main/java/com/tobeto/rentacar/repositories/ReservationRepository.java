package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
