package com.hotel.hotel_backend.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_backend.Entity.Quarto;
import com.hotel.hotel_backend.Entity.Reserva;
import com.hotel.hotel_backend.Repository.QuartoRepository;
import com.hotel.hotel_backend.Repository.ReservaRepository;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable Long id) {
        return reservaRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Reserva salvar(@RequestBody Reserva reserva) {
        Quarto quarto = reserva.getQuarto();
        quarto.setDisponivel(false);
        quartoRepository.save(quarto);
        return reservaRepository.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return reservaRepository.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        reservaRepository.deleteById(id);
    }
}