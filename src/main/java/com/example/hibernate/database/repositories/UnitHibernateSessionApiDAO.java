package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UnitHibernateSessionApiDAO {
    private final SessionFactory sessionFactory;

    @Transactional(Transactional.TxType.REQUIRED)
    public Units getUnitById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Получение текущей сессии
        return session.get(Units.class, id);
    }

    public Units findUnitById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Получение текущей сессии
        return session.find(Units.class, id);
    }

    public void saveUnit(Units user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);  // Сохраняем объект
            transaction.commit();   // Подтверждаем транзакцию
        } catch (Exception e) {
            transaction.rollback(); // В случае ошибки откатываем транзакцию
            e.printStackTrace();
        }
    }

    public void saveOrUpdateUnit(Units user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(user);  // Сохраняем или обновляем объект
            transaction.commit();   // Подтверждаем транзакцию
        } catch (Exception e) {
            transaction.rollback(); // В случае ошибки откатываем транзакцию
            e.printStackTrace();
        }
    }
}