package com.fantalec.fanta.controller;

import com.fantalec.fanta.bussinessLogic.RosterCampioniService;
import com.fantalec.fanta.entity.RosterCampioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roster/campioni")
public class RosterCampioniController {

    @Autowired
    private RosterCampioniService service;

    @GetMapping
    public List<RosterCampioni> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<RosterCampioni> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RosterCampioni create(@RequestBody RosterCampioni r) {
        return service.save(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RosterCampioni> update(@PathVariable UUID id, @RequestBody RosterCampioni r) {
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
