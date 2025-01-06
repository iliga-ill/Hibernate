package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Params;
import com.example.hibernate.database.entities.Units;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParamRepository extends JpaRepository<Params, Long> {

    @EntityGraph(value = "Param.unitAndType", type = EntityGraph.EntityGraphType.FETCH)
    List<Params> findByUnitId(Units units);

}
