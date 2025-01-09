package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
//import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import static com.example.hibernate.database.entities.QUnits.units;
//
//@Repository
//@RequiredArgsConstructor
//public class UnitQueryDslDAO {
//
//    private final EntityManager entityManager;
//
//    @Transactional
//    public Units getUnitByIdWithQueryDSL(Long id) {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
//        return queryFactory.selectFrom(units)
//                .where(units.id.eq(id))
//                .fetchOne();
//    }
//
//}
