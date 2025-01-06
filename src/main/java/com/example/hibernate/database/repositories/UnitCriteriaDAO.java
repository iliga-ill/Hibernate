package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UnitCriteriaDAO {
    private final SessionFactory sessionFactory; //Hibernate
    private final EntityManagerFactory entityManagerFactory; //JPA

    public Units getUnitByIdWithCriteria(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Получение текущей сессии
//        entityManagerFactory.getCriteriaBuilder()

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Units> query = cb.createQuery(Units.class);
        Root<Units> root = query.from(Units.class);

        return session.createQuery(
                query.select(root).where(
                        cb.equal(root.get("id"), id)
                )
        ).getSingleResult();
    }

    public Units getUnitByIdListWithCriteria(List<Long> idList) {
        Session session = sessionFactory.getCurrentSession(); // Получение текущей сессии

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Units> query = cb.createQuery(Units.class);
        Root<Units> root = query.from(Units.class);

        return session.createQuery(
                query.select(root).where(
                        root.get("id").in(idList)
                )
        ).getSingleResult();
    }

}
