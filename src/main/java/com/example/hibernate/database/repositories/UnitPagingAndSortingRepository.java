package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitPagingAndSortingRepository extends PagingAndSortingRepository<Units, Long> {

    /**
     * Как использовать PagingAndSortingRepository
     * 1. Подключение
     * Создайте интерфейс, который расширяет PagingAndSortingRepository:
     *
     * public interface UnitsRepository extends PagingAndSortingRepository<Units, Long> {}
     * Здесь:
     * Units — класс вашей сущности.
     * Long — тип идентификатора.
     *
     * 2. Пример использования
     *
     * Пагинация:
     * Pageable pageable = PageRequest.of(0, 5); // первая страница, 5 записей на страницу
     * Page<Units> page = unitsRepository.findAll(pageable);
     *
     * List<Units> units = page.getContent(); // данные текущей страницы
     * int totalPages = page.getTotalPages(); // общее количество страниц
     * long totalElements = page.getTotalElements(); // общее количество записей
     * boolean isFirst = page.isFirst(); // проверка, первая ли это страница
     * boolean isLast = page.isLast(); // проверка, последняя ли это страница
     *
     * Сортировка:
     * Iterable<Units> sortedUnits = unitsRepository.findAll(Sort.by("dateReg").ascending());
     *
     * Пагинация + сортировка:
     * Pageable pageable = PageRequest.of(0, 5, Sort.by("dateReg").descending());
     * Page<Units> page = unitsRepository.findAll(pageable);
     * List<Units> units = page.getContent();
     *
     * Особенности объектов Pageable и Page
     *
     * Pageable
     * Используется для указания номера страницы, размера страницы и сортировки.
     * Создаётся с помощью фабрики PageRequest.
     *
     * Пример:
     * Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("fieldName").ascending());
     *
     * Page
     * Возвращает метаинформацию о текущей странице:
     *
     * Данные страницы (List<T> getContent()).
     * Номер страницы (int getNumber()).
     * Размер страницы (int getSize()).
     * Общее количество страниц (int getTotalPages()).
     * Общее количество элементов (long getTotalElements()).
     */

}
