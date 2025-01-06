package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitJpqlRepository extends JpaRepository<Units, Long> {

    @EntityGraph(attributePaths = {"params", "params.typeId"})
    @Query("SELECT u FROM Units u WHERE u.id = :id")
    Units findUnitById(@Param("id") Long unitId);

}
