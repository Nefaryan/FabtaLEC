package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.RosterGiocatori;
import com.fantalec.fanta.repository.RosterGiocatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RosterGiocatoriService {

    @Autowired
    private RosterGiocatoreRepository repository;

    public List<RosterGiocatori> findAll() { return repository.findAll(); }
    public Optional<RosterGiocatori> findById(UUID id) { return repository.findById(id); }
    public RosterGiocatori save(RosterGiocatori r) { return repository.save(r); }
    public void delete(UUID id) { repository.deleteById(id); }


}
