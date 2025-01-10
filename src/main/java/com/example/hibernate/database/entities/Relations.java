package com.example.hibernate.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "relations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Relations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false, updatable = false)
    private RelationTypes type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private Units parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private Units child;

    @PrePersist
    private void onCreate(){
        this.dateReg = OffsetDateTime.now();
    }

}
