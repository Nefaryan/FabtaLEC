package com.fantalec.fanta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "team")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private Set<Giocatore> giocatores = new LinkedHashSet<>();

}
