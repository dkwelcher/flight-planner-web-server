package com.flightplanner.flightplannerserver.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "continents")
public class ContinentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long continentId;

    private String continentName;
}
