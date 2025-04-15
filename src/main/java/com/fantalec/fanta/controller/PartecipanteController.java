package com.fantalec.fanta.controller;

import com.fantalec.fanta.bussinessLogic.PartecipanteService;
import com.fantalec.fanta.entity.Partecipante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/partecipanti")
public class PartecipanteController {

    @Autowired
    private PartecipanteService service;

    @GetMapping
    public List<Partecipante> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Partecipante> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partecipante create(@RequestBody Partecipante p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partecipante> update(@PathVariable UUID id, @RequestBody Partecipante p) {
        return service.findById(id)
                .map(existing -> {
                    p.setId(id);
                    return ResponseEntity.ok(service.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
