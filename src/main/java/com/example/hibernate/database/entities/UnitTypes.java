package com.example.hibernate.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "unit_types")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "description")
    private String description;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @PrePersist
    protected void onCreate() {
        this.dateReg = OffsetDateTime.now(); // Устанавливаем текущую дату при создании объекта
    }
}
