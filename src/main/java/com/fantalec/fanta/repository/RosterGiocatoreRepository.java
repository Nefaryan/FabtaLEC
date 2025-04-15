package com.fantalec.fanta.repository;

import com.fantalec.fanta.entity.RosterGiocatori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RosterGiocatoreRepository extends JpaRepository<RosterGiocatori, UUID> {
}
