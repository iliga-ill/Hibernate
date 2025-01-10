package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import com.example.hibernate.services.dto.Unit;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitJpqlRepository extends JpaRepository<Units, Long> {

    @EntityGraph(attributePaths = {"params", "params.typeId", "type"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM Units u WHERE u.id = :id")
    Units findUnitByIdWithEntityGraph(@Param("id") Long unitId);

    @Query("SELECT u FROM Units u WHERE u.id = :id")
    Units findUnitByIdWithoutEntityGraph(@Param("id") Long unitId);

    @Query("SELECT u FROM Units u WHERE u.id = :id")
    Slice<Units> findUnitByIdInSlice(@Param("id") Long unitId);

    /*
    @Query("""
        SELECT new com.example.hibernate.services.dto.Unit(
            u.id,
            u.type.alias
            null
        )
        FROM Units u
        WHERE u.id = :id
    """)
    */

    @Query("""
        SELECT new com.example.hibernate.services.dto.Unit(
            u.id,
            u.type.alias
        )
        FROM Units u
        WHERE u.id = :id
    """)
    Unit findDtoUnitById(@Param("id") Long id);

}
