package com.hotel.hotel_backend.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel_backend.Entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}