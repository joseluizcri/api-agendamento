package br.com.atualize.agendamento.agendamento.resource;

import br.com.atualize.agendamento.agendamento.model.Agenda;
import br.com.atualize.agendamento.agendamento.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendas")
public class AgendaResource {

    @Autowired
    private AgendaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Agenda>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agenda> insert(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(service.insert(agenda));
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agenda> update(@PathVariable("id") Long id, @RequestBody Agenda agenda) {
        if (!id.equals(agenda.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.merge(agenda));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agenda> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
