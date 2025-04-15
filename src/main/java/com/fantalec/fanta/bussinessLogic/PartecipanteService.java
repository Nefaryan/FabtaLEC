package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.Partecipante;
import com.fantalec.fanta.repository.PartecipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartecipanteService {

    @Autowired
    private PartecipanteRepository repository;

    public List<Partecipante> findAll() { return repository.findAll(); }
    public Optional<Partecipante> findById(UUID id) { return repository.findById(id); }
    public Partecipante save(Partecipante p) { return repository.save(p); }
    public void delete(UUID id) { repository.deleteById(id); }


}
