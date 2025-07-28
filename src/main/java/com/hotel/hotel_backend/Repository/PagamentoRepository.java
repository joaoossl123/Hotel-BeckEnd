package com.hotel.hotel_backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel_backend.Entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {}
