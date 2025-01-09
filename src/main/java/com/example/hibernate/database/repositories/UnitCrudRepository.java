package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitCrudRepository extends CrudRepository<Units, Long> {

    /**
     * ----------Особенности работы CrudRepository
     *
     * Поддержка работы с транзакциями:
     * Spring автоматически оборачивает вызовы методов репозитория в транзакции. Например, методы save, delete выполняются в транзакции.
     *
     * Автоматическая генерация запросов:
     * Spring Data JPA автоматически генерирует SQL-запросы на основе вызовов методов репозитория.
     *
     * Гибкость:
     * Можно создавать пользовательские методы, добавляя их в интерфейс репозитория.
     *
     * ---------Кастомизация запросов
     * Если базовых методов недостаточно, можно добавлять свои. Для этого используйте методы с названиями, соответствующими полям сущности.
     * Spring Data JPA автоматически интерпретирует их.
     *
     * Пример:
     * List<Units> findByTypeAlias(String alias);
     *
     * Этот метод автоматически сгенерирует SQL-запрос:
     * SELECT * FROM units u
     * JOIN unit_types ut ON u.type_id = ut.id
     * WHERE ut.alias = :alias
     *
     */

    //CrudRepository поддерживает JPA запросы по типу запроса ниже
    @EntityGraph(attributePaths = {"params", "params.typeId", "type"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM Units u WHERE u.id = :id")
    Units findUnitByIdWithEntityGraph(@Param("id") Long unitId);

}
