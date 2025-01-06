package com.example.hibernate.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "param_types")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParamTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias", nullable = false, updatable = false)
    private String alias;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @PrePersist
    protected void onCreate(){
        this.dateReg = OffsetDateTime.now();
    }

}
