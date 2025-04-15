package com.fantalec.fanta.controller;

import com.fantalec.fanta.bussinessLogic.RosterGiocatoriService;
import com.fantalec.fanta.entity.RosterGiocatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roster/giocatori")
public class RosterGiocatoriController {

    @Autowired
    private RosterGiocatoriService service;

    @GetMapping
    public List<RosterGiocatori> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<RosterGiocatori> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RosterGiocatori create(@RequestBody RosterGiocatori r) {
        return service.save(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RosterGiocatori> update(@PathVariable UUID id, @RequestBody RosterGiocatori r) {
        return service.findById(id)
                .map(existing -> {
                    r.setId(id);
                    return ResponseEntity.ok(service.save(r));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
