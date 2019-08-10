package br.com.atualize.agendamento.agendamento.service;

import br.com.atualize.agendamento.agendamento.model.Agenda;
import br.com.atualize.agendamento.agendamento.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda insert(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda merge(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public List<Agenda> findAll(){
        return agendaRepository.findAll();
    }

    public Agenda findOne(Long id){
        return agendaRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        agendaRepository.deleteById(id);
    }
}
