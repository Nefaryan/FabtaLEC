package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.Campione;
import com.fantalec.fanta.repository.CampioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampioneService {
    @Autowired
    private CampioneRepository repository;

    public List<Campione> findAll() { return repository.findAll(); }
    public Optional<Campione> findById(UUID id) { return repository.findById(id); }
    public Campione save(Campione c) { return repository.save(c); }
    public void delete(UUID id) { repository.deleteById(id); }


}
