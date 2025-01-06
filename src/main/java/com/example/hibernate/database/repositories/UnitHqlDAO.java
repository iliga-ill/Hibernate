package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UnitHqlDAO {
    private final SessionFactory sessionFactory;

    @Transactional
    public Units getUnitsByIdWithHQL(Long id){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Units u WHERE u.id = :id";
        return session.createQuery(hql, Units.class).setParameter("id", id).getSingleResult();
    }


}
