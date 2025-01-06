package com.example.hibernate.services;

import com.example.hibernate.database.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    private final UnitHibernateSessionApiDAO unitHibernateSessionApiDAO;
    private final UnitCriteriaDAO unitCriteriaDAO;
    private final UnitHqlDAO unitHQLDAO;
    private final UnitJpqlDAO unitJpqlDAO;
    private final ParamRepository paramRepository;
    private final UnitJpqlRepository unitJpqlRepository;
    private final EntityManager entityManager;

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void criteriaQuery() {
        var unit = unitCriteriaDAO.getUnitByIdWithCriteria(2L);
        entityManager.flush();
        log.info("");
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hqlQuery() {
        var unit = unitHQLDAO.getUnitsByIdWithHQL(2L);
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiQuery() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L);
        entityManager.flush();
    }

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlDaoQuery() {
        var unit = unitJpqlDAO.getUnitsByIdWithJpql(2L);
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryQuery() {
        var unit = unitJpqlRepository.findUnitById(2L); //TODO проблема с бесконечной вложенностью юнитов и параметров
        entityManager.flush();
    }

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiWithCashL1Query() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L);
        var unitParams = paramRepository.findByUnitId(unit);
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void persistenceContextQuery() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L); //TODO проблема с бесконечной вложенностью юнитов и параметров
        entityManager.flush();

        var unit2 = unitHibernateSessionApiDAO.findUnitById(2L);
        log.info("");
    }



}
