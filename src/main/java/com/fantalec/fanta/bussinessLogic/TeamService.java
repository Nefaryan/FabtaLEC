package com.fantalec.fanta.bussinessLogic;

import com.fantalec.fanta.entity.RosterCampioni;
import com.fantalec.fanta.entity.Team;
import com.fantalec.fanta.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    TeamRepository repository;

    public List<Team> findAll() { return repository.findAll(); }
    public Optional<Team> findById(UUID id) { return repository.findById(id); }
    public Team save(Team r) { return repository.save(r); }
    public void delete(UUID id) { repository.deleteById(id); }

}
