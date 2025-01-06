package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UnitJpqlDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Transactional
    public Units getUnitsByIdWithJpql(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String jpql = "SELECT u FROM Units u WHERE u.id = :id";
        return entityManager.createQuery(jpql, Units.class).setParameter("id", id).getSingleResult();
    }


}
