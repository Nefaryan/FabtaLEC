package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.RosterCampioni;
import com.fantalec.fanta.repository.RosteCampioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RosterCampioniService {

    @Autowired
    private RosteCampioniRepository repository;

    public List<RosterCampioni> findAll() { return repository.findAll(); }
    public Optional<RosterCampioni> findById(UUID id) { return repository.findById(id); }
    public RosterCampioni save(RosterCampioni r) { return repository.save(r); }
    public void delete(UUID id) { repository.deleteById(id); }

}
