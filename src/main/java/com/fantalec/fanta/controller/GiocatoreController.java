package com.fantalec.fanta.controller;

import com.fantalec.fanta.bussinessLogic.GiocatoreService;
import com.fantalec.fanta.entity.Giocatore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/giocatori")
public class GiocatoreController {

    @Autowired
    private GiocatoreService service;

    @GetMapping
    public List<Giocatore> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Giocatore> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Giocatore create(@RequestBody Giocatore g) {
        return service.save(g);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Giocatore> update(@PathVariable UUID id, @RequestBody Giocatore g) {
        return service.findById(id)
                .map(existing -> {
                    g.setId(id);
                    return ResponseEntity.ok(service.save(g));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
