package com.example.hibernate.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Param {
    private Long id;
    private String type;
    private String value_s;
    private Double value_n;
    private OffsetDateTime value_d;
    private String value_j;
}
