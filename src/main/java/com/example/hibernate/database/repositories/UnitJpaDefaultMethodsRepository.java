package com.example.hibernate.database.repositories;

import com.example.hibernate.database.entities.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitJpaDefaultMethodsRepository extends JpaRepository<Units, Long> {

    /**
     * Дефолтные методы репозитория
     *
     * Методы для создания, чтения, обновления и удаления сущностей.
     * save(entity);          // Сохраняет или обновляет сущность
     * findById(id);          // Находит сущность по ID
     * findAll();             // Возвращает все сущности
     * delete(entity);        // Удаляет сущность
     * deleteById(id);        // Удаляет сущность по ID
     *
     * Методы для проверки существования записей:
     * count() — возвращает количество записей.
     * existsById(ID id) — проверяет, существует ли запись с указанным идентификатором.
     *
     * Методы для работы с данными постранично и с сортировкой.
     * findAll(Pageable pageable);    // Пагинация
     * findAll(Sort sort);            // Сортировка
     *
     * Поддержка работы с наборами идентификаторов или сущностей.
     * findAllById(ids);     // Возвращает сущности по списку ID
     * saveAll(entities);    // Сохраняет список сущностей
     *
     * Оптимизированные запросы для массовых операций, таких как удаление или сохранение.
     * deleteAllInBatch();    // Удаляет все записи одной транзакцией
     * saveAndFlush(entity);  // Сохраняет и сбрасывает изменения
     */

    /**
     Составление методов:

     По имени поля:
     findByFieldName(value) — поиск по значению поля FieldName.
     Поля должны соответствовать именам в сущности.

     Сложные условия:
     findByFieldNameAndAnotherFieldName(value1, value2) — поиск по нескольким полям.
     findByFieldNameOrAnotherFieldName(value1, value2) — поиск с использованием логического "или".

     Сравнения и операции:
     findByFieldNameGreaterThan(value) — поиск значений больше заданного.
     findByFieldNameBetween(start, end) — поиск значений в диапазоне.
     findByFieldNameLike(pattern) — поиск по шаблону (с использованием LIKE).

     Сортировка:
     Добавление ключевого слова OrderBy позволяет указать порядок:
     List<Units> findByTypeAliasOrderByDateRegDesc(String alias);
     */


    List<Units> findByTypeAlias(String alias);

}
