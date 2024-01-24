package com.example.warcraft3.repository;

import com.example.warcraft3.entity.Hero;
import com.example.warcraft3.entity.SearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query("SELECT h FROM Hero h " +
            "WHERE LOWER(h.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(h.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Hero> searchByFields(@Param("searchTerm") String searchTerm);

    @Query("SELECT h FROM Hero h " +
            "WHERE (:#{#criteria.searchTerm} IS NULL OR LOWER(h.name) LIKE LOWER(CONCAT('%', :#{#criteria.searchTerm}, '%'))) " +
            "AND (:#{#criteria.searchRace} IS NULL OR h.race = :#{#criteria.searchRace}) " +
            "AND (:#{#criteria.searchPrimaryAttribute} IS NULL OR h.primaryAttribute = :#{#criteria.searchPrimaryAttribute}) " +
            "AND (:#{#criteria.movementSpeed} IS NULL OR h.movementSpeed = :#{#criteria.movementSpeed})")
    List<Hero> searchByCriteria(@Param("criteria") SearchCriteria criteria);
}