package com.fantalec.fanta.controller;

import com.fantalec.fanta.bussinessLogic.CampioneService;
import com.fantalec.fanta.entity.Campione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/campioni")
public class CampioneController {

    @Autowired
    private CampioneService service;

    @GetMapping
    public List<Campione> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Campione> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Campione create(@RequestBody Campione c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campione> update(@PathVariable UUID id, @RequestBody Campione c) {
        return service.findById(id)
                .map(existing -> {
                    c.setId(id);
                    return ResponseEntity.ok(service.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }




}
