package com.hotel.hotel_backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel_backend.Entity.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {}