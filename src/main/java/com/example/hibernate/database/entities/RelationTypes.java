package com.example.hibernate.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "relation_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelationTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @Column(name = "alias", nullable = false, updatable = false, unique = true)
    private String alias;

    @Column(name = "description")
    private String description;

    @PrePersist
    private void onCreate(){
        this.dateReg = OffsetDateTime.now();
    }

}
