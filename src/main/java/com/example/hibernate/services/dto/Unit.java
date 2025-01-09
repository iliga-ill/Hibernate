package com.example.hibernate.services.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unit {
    private Long id;
    private String type;
    private List<Param> params;

    public Unit(Long id, String type) {
        this.id = id;
        this.type = type;
        this.params = new ArrayList<>();
    }

}
