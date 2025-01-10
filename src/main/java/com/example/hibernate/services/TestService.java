package com.example.hibernate.services;

import com.example.hibernate.database.entities.Units;
import com.example.hibernate.database.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(Transactional.TxType.REQUIRED)
public class TestService {
    private final UnitHibernateSessionApiDAO unitHibernateSessionApiDAO;
    private final UnitCriteriaDAO unitCriteriaDAO;
    private final UnitHqlDAO unitHQLDAO;
    private final UnitJpqlDAO unitJpqlDAO;
    private final ParamRepository paramRepository;
    private final UnitJpqlRepository unitJpqlRepository;
    private final UnitJpaDefaultMethodsRepository unitJpaDefaultMethodsRepository;
    private final UnitCrudRepository unitCrudRepository;
    private final UnitPagingAndSortingRepository pagingAndSortingRepository;
    private final UnitNativeSqlRepository unitNativeSqlRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    //region Hibernate Session Api

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiQuery() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L);
        entityManager.flush();
    }

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiUnitAndParams() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L);
        var unitParams = paramRepository.findByUnitId(unit);
        entityManager.flush();
    }

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiWithCashL1Query() {
        var unit = unitHibernateSessionApiDAO.getUnitById(2L);
        entityManager.flush();

        var unit2 = unitHibernateSessionApiDAO.findUnitById(2L);
        log.info("");
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hibernateSessionApiWithCashL2Query() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Первый вызов — загрузка данных из базы данных
        Units unit = unitCrudRepository.findUnitByIdWithEntityGraph(2L);

        // Закрываем сессию, чтобы проверить работу кэша второго уровня
        entityManager.close();
        log.info("------------------closed-----------------");
        // Открываем новую сессию
        entityManager = entityManagerFactory.createEntityManager();

        // Второй вызов — загрузка из кэша второго уровня
        Units cachedUnit = entityManager.find(Units.class, 2L);
        log.info("------------------closed-----------------");

    }

    //endregion

    //region HQL

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void hqlQuery() {
        var unit = unitHQLDAO.getUnitsByIdWithHQL(2L);
        entityManager.flush();
    }

    //endregion

    //region JPQL

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlDaoQuery() {
        var unit = unitJpqlDAO.getUnitsByIdWithJpql(2L);
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryEntityGraphQuery() {
        var unit = unitJpqlRepository.findUnitByIdWithEntityGraph(2L); //with entity graph 1 query to db to extract data
        var unit2 = unitJpqlRepository.findUnitByIdWithoutEntityGraph(2L); //without entity graph 3 queries to db to extract data
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryDtoUnitQuery() {
        var unit = unitJpqlRepository.findDtoUnitById(2L); //TODO непонятно можно ли через JPQL/HQL вытащить юнит вместе с параметрами, new нельзя применять вложенно обьект в обьект, и null не распознается конструктором
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryDefaultQueries() {
        var unit = unitJpaDefaultMethodsRepository.findById(2L); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryMethodNamingConventionQueries() {
        var unit = unitJpaDefaultMethodsRepository.findByTypeAlias("unit_1"); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        unitJpaDefaultMethodsRepository.findByTypeAlias("unit_1");
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void jpqlRepositoryMethodNamingConventionQueriesWithSlice() {
        var unit = unitJpqlRepository.findUnitByIdInSlice(2L); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void crudRepositoryQueries() {
        var unit = unitCrudRepository.findUnitByIdWithEntityGraph(2L); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        entityManager.flush();
    }

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void pagingAndSortingRepositoryQueries() {
        var unit = pagingAndSortingRepository.findAll(Sort.by("id").descending()); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц

        var page = PageRequest.of(0,1);
        var unit1 = pagingAndSortingRepository.findAll(page); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        page = page.next();
        var unit2 = pagingAndSortingRepository.findAll(page);

        var unit3 = pagingAndSortingRepository.findAll(PageRequest.of(0,1, Sort.by("id").descending())); //работает без Entity Graph, сильно спамит запросами при подтягивании данных из разных таблиц
        entityManager.flush();
    }



    //endregion

    //region Criteria Api

    //    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void criteriaQuery() {
        var unit = unitCriteriaDAO.getUnitByIdWithCriteria(2L);
        entityManager.flush();
        log.info("");
    }

    //endregion

    //region Native SQL

//    @Scheduled(fixedDelay = 100000)
    @Transactional(Transactional.TxType.REQUIRED)
    public void nativeSqlQuery() {
        var unit = unitNativeSqlRepository.findUnitWithParamsNative(2L);
        entityManager.flush();
        log.info("");
    }

    //endregion

}
