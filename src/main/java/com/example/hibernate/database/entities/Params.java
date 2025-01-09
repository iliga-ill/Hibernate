package com.example.hibernate.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.OffsetDateTime;

@Entity
@Table(name = "params")
@NamedEntityGraph(
        name = "Param.unitAndType",
        attributeNodes = {
                @NamedAttributeNode("unitId"),
                @NamedAttributeNode("typeId")
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Params {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private Units unitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private ParamTypes typeId;

    @Column(name = "date_reg", nullable = false, updatable = false)
    private OffsetDateTime dateReg;

    @Column(name = "value_n")
    private Double valueN;

    @Column(name = "value_s")
    private String valueS;

    @Column(name = "value_d")
    private OffsetDateTime valueD;

    @Column(name = "value_j")
    private String valueJ;

    @PrePersist
    protected void onCreate(){
        this.dateReg = OffsetDateTime.now();
    }

}
