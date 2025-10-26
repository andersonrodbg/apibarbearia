package com.barbearia.service;

import com.barbearia.model.Agendamento;
import com.barbearia.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento salvar(Agendamento agendamento) {
        
        if (existeAgendamentoNoMesmoHorario(agendamento.getData(), agendamento.getHora())) {
            throw new RuntimeException("Já existe um agendamento para esse horário!");
        }
        return repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public List<Agendamento> listarPorData(LocalDate data) {
        return repository.findByData(data);
    }

    public Optional<Agendamento> atualizarStatus(Long id, String status) {
        Optional<Agendamento> agendamento = repository.findById(id);
        if (agendamento.isPresent()) {
            agendamento.get().setStatus(status);
            repository.save(agendamento.get());
        }
        return agendamento;
    }

    private boolean existeAgendamentoNoMesmoHorario(LocalDate data, LocalTime hora) {
        List<Agendamento> agendamentosDoDia = repository.findByData(data);
        return agendamentosDoDia.stream()
                .anyMatch(a -> a.getHora().equals(hora));
    }
}
