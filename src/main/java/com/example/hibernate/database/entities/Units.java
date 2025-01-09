package com.example.hibernate.database.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "units")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private UnitTypes type;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @OneToMany(mappedBy = "unitId", fetch = FetchType.LAZY)
    private List<Params> params;

    @PrePersist
    protected void onCreate() {
        this.dateReg = OffsetDateTime.now(); // Устанавливаем текущую дату при создании объекта
    }
}
