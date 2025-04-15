package com.fantalec.fanta.repository;

import com.fantalec.fanta.entity.Campione;
import com.fantalec.fanta.entity.Partecipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampioneRepository extends JpaRepository<Campione, UUID> {
}
