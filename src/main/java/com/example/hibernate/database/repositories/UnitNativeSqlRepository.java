package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import com.example.hibernate.services.dto.Unit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitNativeSqlRepository extends JpaRepository<Units, Long> {

    @Query(value = """
        SELECT u.id AS unitId, ut.alias AS unitType, 
               p.id AS paramId, pt.alias AS paramType, 
               p.value_s, p.value_n, p.value_d, p.value_j
        FROM units u
        LEFT JOIN params p ON p.unit_id = u.id
        LEFT JOIN param_types pt ON pt.id = p.type_id
        LEFT JOIN unit_types ut ON ut.id = u.type_id
        WHERE u.id = :id
    """, nativeQuery = true)
    List<Object[]> findUnitWithParamsNative(@Param("id") Long id);


}
