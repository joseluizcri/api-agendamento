package br.com.atualize.agendamento.agendamento.repository;

import br.com.atualize.agendamento.agendamento.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
