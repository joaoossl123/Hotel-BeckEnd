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
    
import com.hotel.hotel_backend.Entity.Hospede;
import com.hotel.hotel_backend.Repository.HospedeRepository;


@RestController
@RequestMapping("/api/hospedes")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public List<Hospede> listar() {
        return hospedeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hospede buscar(@PathVariable Long id) {
        return hospedeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Hospede salvar(@RequestBody Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @PutMapping("/{id}")
    public Hospede atualizar(@PathVariable Long id, @RequestBody Hospede hospede) {
        hospede.setId(id);
        return hospedeRepository.save(hospede);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        hospedeRepository.deleteById(id);
    }
}