package com.fantalec.fanta.repository;

import com.fantalec.fanta.entity.RosterCampioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RosteCampioniRepository extends JpaRepository<RosterCampioni, UUID> {}
