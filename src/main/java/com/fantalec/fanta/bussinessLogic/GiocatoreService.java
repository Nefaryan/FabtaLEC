package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.Giocatore;
import com.fantalec.fanta.repository.GiocatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiocatoreService {

    @Autowired
    private GiocatoreRepository repository;

    public List<Giocatore> findAll() { return repository.findAll(); }
    public Optional<Giocatore> findById(UUID id) { return repository.findById(id); }
    public Giocatore save(Giocatore g) { return repository.save(g); }
    public void delete(UUID id) { repository.deleteById(id); }


}
