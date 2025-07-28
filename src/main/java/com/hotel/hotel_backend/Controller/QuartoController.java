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
import com.hotel.hotel_backend.Repository.QuartoRepository;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping
    public List<Quarto> listar() {
        return quartoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Quarto buscar(@PathVariable Long id) {
        return quartoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Quarto salvar(@RequestBody Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    @PutMapping("/{id}")
    public Quarto atualizar(@PathVariable Long id, @RequestBody Quarto quarto) {
        quarto.setId(id);
        return quartoRepository.save(quarto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        quartoRepository.deleteById(id);
    }
}
