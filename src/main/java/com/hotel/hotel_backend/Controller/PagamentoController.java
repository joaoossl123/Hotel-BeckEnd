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

import com.hotel.hotel_backend.Entity.Pagamento;
import com.hotel.hotel_backend.Repository.PagamentoRepository;


@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listar() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento buscar(@PathVariable Long id) {
        return pagamentoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Pagamento salvar(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        pagamento.setId(id);
        return pagamentoRepository.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);
    }
}
