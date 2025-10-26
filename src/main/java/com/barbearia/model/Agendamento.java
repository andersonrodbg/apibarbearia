package com.barbearia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String telefone;
    private LocalDate data;
    private LocalTime hora;
    private String status = "AGENDADO";

          public Agendamento() {}

    public Agendamento(String nomeCliente, String telefone, LocalDate data, LocalTime hora) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.data = data;
        this.hora = hora;
        this.status = "AGENDADO";
    }

    public Long getId() { return id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
