package com.barbearia.controller;

import com.barbearia.model.Agendamento;
import com.barbearia.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return service.salvar(agendamento);
    }

    @GetMapping
    public List<Agendamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/data/{data}")
    public List<Agendamento> listarPorData(@PathVariable String data) {
        return service.listarPorData(LocalDate.parse(data));
    }

    @PutMapping("/{id}/status")
    public Optional<Agendamento> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }
}

